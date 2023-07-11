package com.sdu.internalcommon.util;

/**
 * @author LHP
 * @date 2023-07-11 11:23
 * @description
 */
public class RedisPrefixUtils {

    // 乘客验证码的前缀
    public static String verificationCodePrefix = "passenger-verification-code-";

    // token的前缀
    public static String tokenPrefix = "token-";

    /**
     * 根据手机号生成redis中的key
     * @param passengerPhone 乘客手机号
     * @return
     */
    public static String generateKeyByPhone(String passengerPhone) {
        return verificationCodePrefix + passengerPhone;
    }

    /**
     * 根据手机号和身份生成token的key
     * @param phone
     * @param identity
     * @return
     */
    public static String generateTokenKey(String phone, String identity) {
        return tokenPrefix + phone + "-" + identity;
    }

}
