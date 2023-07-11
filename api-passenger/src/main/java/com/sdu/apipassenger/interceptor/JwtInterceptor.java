package com.sdu.apipassenger.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.internalcommon.util.JwtUtils;
import net.sf.json.JSONObject;
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
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean result = true;
        String resultString = "";

        // 1.从header中获取token
        String token = request.getHeader("Authorization");
        // 2.解析token，校验token是否有效
        try {
            JwtUtils.parseToken(token);
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

        if (!result) {
            PrintWriter out = response.getWriter();
            out.print(JSONObject.fromObject(ResponseResult.fail(resultString)).toString());
        }

        return result;
    }
}
