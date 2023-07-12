package com.sdu.apiboss.remote;

import com.sdu.internalcommon.dto.DriverUser;
import com.sdu.internalcommon.dto.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author LHP
 * @date 2023-07-12 21:39
 * @description
 */

@FeignClient("service-driver-user")
public interface ServiceDriverUserClient {
    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public ResponseResult addDriverUser(@RequestBody DriverUser driverUser);

    @RequestMapping(method = RequestMethod.PUT, value = "/user")
    public ResponseResult updateDriverUser(@RequestBody DriverUser driverUser);
}
