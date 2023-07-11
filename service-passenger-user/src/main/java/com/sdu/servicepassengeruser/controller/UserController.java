package com.sdu.servicepassengeruser.controller;

import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.internalcommon.request.VerificationCodeDTO;
import com.sdu.servicepassengeruser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LHP
 * @date 2023-07-10 23:26
 * @description
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseResult loginOrRegister(@RequestBody VerificationCodeDTO verificationCodeDTO) {
        // 接收参数（获取手机号）
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        System.out.println("手机号：" + passengerPhone);
        return userService.loginOrRegister(passengerPhone);
    }

}
