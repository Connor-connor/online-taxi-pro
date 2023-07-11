package com.sdu.apipassenger.remote;

import com.sdu.internalcommon.dto.PassengerUser;
import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.internalcommon.request.VerificationCodeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author LHP
 * @date 2023-07-11 0:42
 * @description 远程调用service-passenger-user服务
 */

@FeignClient(name = "service-passenger-user")
public interface ServicePassengerUserClient {

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public ResponseResult loginOrRegister(@RequestBody VerificationCodeDTO verificationCodeDTO);

    @RequestMapping(method = RequestMethod.GET, value = "/user/{phone}") // 防止feign的post转get的bug
    public ResponseResult<PassengerUser> getUserByPhone(@PathVariable("phone") String phone);

}
