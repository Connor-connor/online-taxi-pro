package com.sdu.servicemap.service;

import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.internalcommon.response.DirectionResponse;
import org.springframework.stereotype.Service;

/**
 * @author LHP
 * @date 2023-07-12 1:29
 * @description
 */

@Service
public class DirectionService {

    /**
     * 根据出发地和目的地经纬度，获取距离（米）和时长（分钟）
     * @param depLongitude
     * @param depLatitude
     * @param destLongitude
     * @param destLatitude
     * @return
     */
    public ResponseResult driving(String depLongitude, String depLatitude, String destLongitude, String destLatitude) {

        DirectionResponse directionResponse = new DirectionResponse();
        directionResponse.setDistance(123);
        directionResponse.setDuration(10);

        return ResponseResult.success(directionResponse);
    }

}
