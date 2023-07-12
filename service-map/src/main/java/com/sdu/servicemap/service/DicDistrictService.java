package com.sdu.servicemap.service;

import com.sdu.internalcommon.constant.AmapConfigConstants;
import com.sdu.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author LHP
 * @date 2023-07-12 11:50
 * @description
 */

@Service
public class DicDistrictService {

    @Value("${amap.key}")
    private String amapKey;

    public ResponseResult initDicDistrict(String keywords) {

        // https://restapi.amap.com/v3/config/district?keywords=北京&subdistrict=2&key=78462a297c925d75cbfbf4e58c8e1b95
        // 拼装请求的url
        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.DISTRICT_URL);
        url.append("?");
        url.append("keywords=" + keywords);
        url.append("&");
        url.append("subdistrict=3");
        url.append("&");
        url.append("key=" + amapKey);

        // 解析结果

        // 插入数据库

        return ResponseResult.success();
    }

}
