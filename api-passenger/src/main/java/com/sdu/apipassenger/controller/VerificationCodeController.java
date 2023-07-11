package com.sdu.apipassenger.controller;

import com.sdu.apipassenger.service.VerificationCodeService;
import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.internalcommon.request.VerificationCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LHP
 * @date 2023-07-10 1:12
 * @description 验证码控制器
 */

@RestController
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @GetMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO) {

        // 接收参数（获取手机号）
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        // System.out.println("接收到的手机号参数：" + passengerPhone);

        return verificationCodeService.generatorCode(passengerPhone);
    }

    @PostMapping("/verification-code-check")
    public ResponseResult checkVerificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO) {
        // 接收参数（获取手机号）
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        String verificationCode = verificationCodeDTO.getVerificationCode();

        System.out.println("手机号：" + passengerPhone + "验证码：" + verificationCode);

        return verificationCodeService.checkCode(passengerPhone, verificationCode);
    }
}
