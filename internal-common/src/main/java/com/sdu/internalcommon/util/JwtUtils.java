package com.sdu.internalcommon.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sdu.internalcommon.dto.TokenResult;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LHP
 * @date 2023-07-11 1:20
 * @description jwt工具类
 */
public class JwtUtils {

    // 盐
    private static final String SIGN = "!sop@WDT^&*()_+";

    private static final String JWT_KEY_PHONE = "phone";

    // 1-乘客，2-司机
    private static final String JWT_KEY_IDENTITY = "identity";

    // 生成token
    public static String generateToken(String passengerPhone, String identity) {
        Map<String, String> map = new HashMap<>();
        map.put(JWT_KEY_PHONE, passengerPhone);
        map.put(JWT_KEY_IDENTITY, identity);

        // token有效期
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date date = calendar.getTime();

        JWTCreator.Builder builder = JWT.create();

        // 整合map
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        // 整合有效期
        builder.withExpiresAt(date);

        // 加盐，生成token
        String sign = builder.sign(Algorithm.HMAC256(SIGN));

        return sign;
    }

    // 解析token
    public static TokenResult parseToken(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        String phone = verify.getClaim(JWT_KEY_PHONE).toString();
        String identity = verify.getClaim(JWT_KEY_IDENTITY).toString();

        TokenResult tokenResult = new TokenResult();
        tokenResult.setPhone(phone);
        tokenResult.setIdentity(identity);
        return tokenResult;



    }

/*    public static void main(String[] args) {
        String s = generateToken("15553581029", "1");
        System.out.println("生成的token：" + s);
        System.out.println("解析-------------");
        TokenResult tokenResult = parseToken(s);
        System.out.println("手机号：" + tokenResult.getPhone());
        System.out.println("身份：" + tokenResult.getIdentity());
    }*/

}
