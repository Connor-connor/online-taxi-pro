package com.sdu.serviceprice.service;

import com.sdu.internalcommon.constant.CommonStatusEnum;
import com.sdu.internalcommon.dto.PriceRule;
import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.internalcommon.request.ForecastPriceDTO;
import com.sdu.internalcommon.response.DirectionResponse;
import com.sdu.internalcommon.response.ForecastPriceResponse;
import com.sdu.serviceprice.mapper.PriceRuleMapper;
import com.sdu.serviceprice.remote.ServiceMapClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author LHP
 * @date 2023-07-12 0:46
 * @description
 */

@Service
@Slf4j
public class ForecastPriceService {

    @Autowired
    private ServiceMapClient serviceMapClient;

    @Autowired
    private PriceRuleMapper priceRuleMapper;

    /**
     * 根据出发地和目的地经纬度，预估价格
     * @param depLongitude
     * @param depLatitude
     * @param destLongitude
     * @param destLatitude
     * @return
     */
    public ResponseResult forecastPrice(String depLongitude, String depLatitude, String destLongitude, String destLatitude) {

        log.info("出发地经度：" + depLongitude);
        log.info("出发地纬度：" + depLatitude);
        log.info("目的地经度：" + destLongitude);
        log.info("目的地纬度：" + destLatitude);

        log.info("调用地图服务，查询距离和时长");
        ForecastPriceDTO forecastPriceDTO = new ForecastPriceDTO();
        forecastPriceDTO.setDepLongitude(depLongitude);
        forecastPriceDTO.setDepLatitude(depLatitude);
        forecastPriceDTO.setDestLongitude(destLongitude);
        forecastPriceDTO.setDestLatitude(destLatitude);
        ResponseResult<DirectionResponse> direction = serviceMapClient.direction(forecastPriceDTO);
        Integer distance = direction.getData().getDistance();
        Integer duration = direction.getData().getDuration();
        log.info("距离：" + distance + "，时长：" + duration);

        log.info("读取计价规则");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("city_code", "110000");
        queryMap.put("vehicle_type", "1");
        List<PriceRule> priceRules = priceRuleMapper.selectByMap(queryMap);
        if (priceRules.size() == 0) {
            return ResponseResult.fail(CommonStatusEnum.PRICE_NOT_EXISTS.getCode(), CommonStatusEnum.PRICE_NOT_EXISTS.getValue());
        }

        PriceRule priceRule = priceRules.get(0);

        log.info("根据距离、时长和计价规则，计算价格");

        ForecastPriceResponse forecastPriceResponse = new ForecastPriceResponse();
        forecastPriceResponse.setPrice(12.34);
        return ResponseResult.success(forecastPriceResponse);
    }

}
