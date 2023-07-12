package com.sdu.servicedriveruser.controller;


import com.sdu.internalcommon.dto.Car;
import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.servicedriveruser.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端控制器
 * @author 李浩鹏
 * @since 2023-07-13
 */
@RestController
public class CarController {
    @Autowired
    CarService carService;

    @PostMapping("/car")
    public ResponseResult addCar(@RequestBody Car car){
        return carService.addCar(car);
    }

}
