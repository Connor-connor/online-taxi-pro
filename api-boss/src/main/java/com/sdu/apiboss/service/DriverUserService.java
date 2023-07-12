package com.sdu.apiboss.service;

import com.sdu.apiboss.remote.ServiceDriverUserClient;
import com.sdu.internalcommon.dto.DriverUser;
import com.sdu.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LHP
 * @date 2023-07-12 21:24
 * @description
 */

@Service
public class DriverUserService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult addDriverUser(DriverUser driverUser){
        return serviceDriverUserClient.addDriverUser(driverUser);
    }

    public ResponseResult updateDriverUser(DriverUser driverUser){
        return serviceDriverUserClient.updateDriverUser(driverUser);
    }

}
