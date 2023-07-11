package com.sdu.apipassenger.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.sdu.internalcommon.constant.TokenConstants;
import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.internalcommon.dto.TokenResult;
import com.sdu.internalcommon.util.JwtUtils;
import com.sdu.internalcommon.util.RedisPrefixUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author LHP
 * @date 2023-07-11 8:18
 * @description jwt拦截器
 */
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean result = true;
        String resultString = "";

        // 从header中获取token
        String token = request.getHeader("Authorization");
        // 解析token，校验token是否有效
        TokenResult tokenResult = null;
        try {
            tokenResult = JwtUtils.parseToken(token);
        } catch (SignatureVerificationException e) { // token签名错误
            resultString = "token sign error";
            result = false;
        } catch (TokenExpiredException e) { // token过期
            resultString = "token time out";
            result = false;
        } catch (AlgorithmMismatchException e) { // token算法不一致
            resultString = "token algorithm mismatch";
            result = false;
        } catch (Exception e) { // token无效
            resultString = "token is invalid";
            result = false;
        }

        if (tokenResult == null) {
            resultString = "token is invalid";
            result = false;
        } else {
            // 拼接key（我们传入的token的key）
            String phone = tokenResult.getPhone();
            String identity = tokenResult.getIdentity();
            String tokenKey = RedisPrefixUtils.generateTokenKey(phone, identity, TokenConstants.ACCESS_TOKEN_TYPE);

            // 从redis中获取token
            String redisToken = stringRedisTemplate.opsForValue().get(tokenKey);
            if (StringUtils.isBlank(redisToken)) {
                resultString = "token is invalid";
                result = false;
            } else {
                // 比较我们传入的token和redis中的token是否一致
                if (!token.trim().equals(redisToken.trim())) {
                    resultString = "token is invalid";
                    result = false;
                }
            }
        }

        if (!result) {
            PrintWriter out = response.getWriter();
            out.print(JSONObject.fromObject(ResponseResult.fail(resultString)).toString());
        }

        return result;
    }
}
