package com.sdu.servicemap.service;

import com.sdu.internalcommon.constant.AmapConfigConstants;
import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.servicemap.remote.MapDicDistrictClient;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author LHP
 * @date 2023-07-12 11:50
 * @description
 */

@Service
public class DicDistrictService {

    @Autowired
    private MapDicDistrictClient mapDicDistrictClient;

    public ResponseResult initDicDistrict(String keywords) {

        // 请求地图
        String dicDistrict = mapDicDistrictClient.dicDistrict(keywords);
        System.out.println(dicDistrict);

        // 解析结果

        // 插入数据库

        return ResponseResult.success();
    }

}
