package com.sdu.servicedriveruser.service.impl;

import com.sdu.internalcommon.dto.Car;
import com.sdu.servicedriveruser.mapper.CarMapper;
import com.sdu.servicedriveruser.service.ICarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 李浩鹏
 * @since 2023-07-13
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {

}
