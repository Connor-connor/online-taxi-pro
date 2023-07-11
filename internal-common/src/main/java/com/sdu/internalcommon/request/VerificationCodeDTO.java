package com.sdu.internalcommon.request;

import lombok.Data;

/**
 * @author LHP
 * @date 2023-07-10 1:15
 * @description 验证码请求参数类
 */

@Data
public class VerificationCodeDTO {

    private String passengerPhone;

    private String verificationCode;
}
