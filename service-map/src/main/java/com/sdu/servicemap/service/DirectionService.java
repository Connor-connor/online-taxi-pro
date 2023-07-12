package com.sdu.servicemap.service;

import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.internalcommon.response.DirectionResponse;
import com.sdu.servicemap.remote.MapDirectionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LHP
 * @date 2023-07-12 1:29
 * @description
 */

@Service
public class DirectionService {

    @Autowired
    private MapDirectionClient mapDirectionClient;

    /**
     * 根据出发地和目的地经纬度，获取距离（米）和时长（分钟）
     * @param depLongitude
     * @param depLatitude
     * @param destLongitude
     * @param destLatitude
     * @return
     */
    public ResponseResult driving(String depLongitude, String depLatitude, String destLongitude, String destLatitude) {

        // 调用第三方地图接口
        DirectionResponse direction = mapDirectionClient.direction(depLongitude, depLatitude, destLongitude, destLatitude);

        return ResponseResult.success(direction);
    }
}
