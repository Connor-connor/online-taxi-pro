package com.sdu.internalcommon.util;

/**
 * @author LHP
 * @date 2023-07-11 11:23
 * @description
 */
public class RedisPrefixUtils {

    // 乘客验证码的前缀
    public static String verificationCodePrefix = "verification-code-";

    // token的前缀
    public static String tokenPrefix = "token-";

    // 黑名单设备号
    public static String blackDeviceCodePrefix = "black-device-";

    /**
     * 根据手机号生成redis中的key
     * @param phone 手机号
     * @param identity 身份
     * @return
     */
    public static String generateKeyByPhone(String phone, String identity) {
        return verificationCodePrefix + identity + "-" + phone;
    }

    /**
     * 根据手机号和身份生成token的key
     * @param phone
     * @param identity
     * @return
     */
    public static String generateTokenKey(String phone, String identity, String tokenType) {
        return tokenPrefix + phone + "-" + identity + "-" + tokenType;
    }

}
