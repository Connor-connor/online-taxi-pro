package com.sdu.apipassenger.service;

import com.sdu.internalcommon.dto.PassengerUser;
import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.internalcommon.dto.TokenResult;
import com.sdu.internalcommon.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author LHP
 * @date 2023-07-11 21:47
 * @description
 */

@Service
@Slf4j
public class UserService {

    public ResponseResult getUserByAccessToken(String accessToken) {

        log.info("accessToken:" + accessToken);

        // 解析accessToken，获取手机号
        TokenResult tokenResult = JwtUtils.checkToken(accessToken);
        String phone = tokenResult.getPhone();
        log.info("手机号：" + phone);


        // 根据手机号查询用户信息

        PassengerUser passengerUser = new PassengerUser();
        passengerUser.setPassengerName("LHP");
        passengerUser.setProfilePhoto("头像");


        return ResponseResult.success(passengerUser);
    }

}