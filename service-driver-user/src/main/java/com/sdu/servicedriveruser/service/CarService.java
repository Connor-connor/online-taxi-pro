package com.sdu.servicedriveruser.service;

import com.sdu.internalcommon.dto.Car;
import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.servicedriveruser.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author 李浩鹏
 * @since 2023-07-13
 */
@Service
public class CarService {

    @Autowired
    private CarMapper carMapper;

    public ResponseResult addCar(Car car){
        LocalDateTime now = LocalDateTime.now();
        car.setGmtCreate(now);
        car.setGmtModified(now);

        carMapper.insert(car);
        return ResponseResult.success("");
    }

}
