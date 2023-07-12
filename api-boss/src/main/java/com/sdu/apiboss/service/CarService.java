package com.sdu.apiboss.service;

import com.sdu.apiboss.remote.ServiceDriverUserClient;
import com.sdu.internalcommon.dto.Car;
import com.sdu.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LHP
 * @date 2023-07-13 2:16
 * @description
 */

@Service
public class CarService {

    @Autowired
    ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult addCar(Car car){
        return serviceDriverUserClient.addCar(car);
    }

}
