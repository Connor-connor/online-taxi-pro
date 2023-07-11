package com.sdu.servicepassengeruser.service;

import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.servicepassengeruser.dto.PassengerUser;
import com.sdu.servicepassengeruser.mapper.PassengerUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author LHP
 * @date 2023-07-10 23:43
 * @description
 */

@Service
public class UserService {

    @Autowired
    private PassengerUserMapper passengerUserMapper;

    public ResponseResult loginOrRegister(String passengerPhone) {
        System.out.println("user service, passengerPhone: " + passengerPhone);

        // 根据手机号查询用户信息
        Map<String, Object> map = new HashMap<>();
        map.put("passenger_phone", passengerPhone);
        List<PassengerUser> passengerUsers = passengerUserMapper.selectByMap(map);
        System.out.println(passengerUsers.size()==0?"无记录":passengerUsers.get(0).getPassengerPhone());

        // 判断用户信息是否存在
        if (passengerUsers.size()==0) {
            // 如果不存在，插入用户信息（注册用户）
            PassengerUser passengerUser = new PassengerUser();
            passengerUser.setPassengerName("张三");
            passengerUser.setPassengerPhone(passengerPhone);
            passengerUser.setPassengerGender((byte) 1);
            passengerUser.setState((byte) 0); // 0-有效
            LocalDateTime now = LocalDateTime.now();
            passengerUser.setGmtCreate(now);
            passengerUser.setGmtModified(now);
            passengerUserMapper.insert(passengerUser);
        }

        return ResponseResult.success("");
    }

}
