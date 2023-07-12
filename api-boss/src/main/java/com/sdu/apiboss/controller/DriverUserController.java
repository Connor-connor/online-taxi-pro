package com.sdu.apiboss.controller;

import com.sdu.apiboss.service.CarService;
import com.sdu.apiboss.service.DriverUserService;
import com.sdu.internalcommon.dto.Car;
import com.sdu.internalcommon.dto.DriverUser;
import com.sdu.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LHP
 * @date 2023-07-12 21:19
 * @description
 */

@RestController
public class DriverUserController {

    @Autowired
    private DriverUserService driverUserService;

    /**
     * 添加驾驶员
     * @param driverUser
     * @return
     */
    @PostMapping("/driver-user")
    public ResponseResult addDriverUser(@RequestBody DriverUser driverUser){
        return driverUserService.addDriverUser(driverUser);
    }

    /**
     * 修改驾驶员信息
     * @param driverUser
     * @return
     */
    @PutMapping("/driver-user")
    public ResponseResult updateDriverUser(@RequestBody DriverUser driverUser){
        return driverUserService.updateDriverUser(driverUser);
    }

    @Autowired
    CarService carService;

    @PostMapping("/car")
    public ResponseResult car(@RequestBody Car car){
        return carService.addCar(car);
    }

}
