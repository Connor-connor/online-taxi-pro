package com.sdu.apipassenger.service;

import com.sdu.apipassenger.remote.ServicePriceClient;
import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.internalcommon.request.ForecastPriceDTO;
import com.sdu.internalcommon.response.ForecastPriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LHP
 * @date 2023-07-12 0:06
 * @description
 */

@Service
@Slf4j
public class ForecastPriceService {

    @Autowired
    ServicePriceClient servicePriceClient;

    /**
     * 根据出发地和目的地经纬度，预估价格
     * @param depLongitude
     * @param depLatitude
     * @param destLongitude
     * @param destLatitude
     * @return
     */
    public ResponseResult forecastPrice(String depLongitude, String depLatitude, String destLongitude, String destLatitude, String cityCode, String vehicleType) {

        log.info("出发地经度：" + depLongitude);
        log.info("出发地纬度：" + depLatitude);
        log.info("目的地经度：" + destLongitude);
        log.info("目的地纬度：" + destLatitude);

        log.info("调用计价服务，预估价格");
        ForecastPriceDTO forecastPriceDTO = new ForecastPriceDTO();
        forecastPriceDTO.setDepLongitude(depLongitude);
        forecastPriceDTO.setDepLatitude(depLatitude);
        forecastPriceDTO.setDestLongitude(destLongitude);
        forecastPriceDTO.setDestLatitude(destLatitude);
        forecastPriceDTO.setCityCode(cityCode);
        forecastPriceDTO.setVehicleType(vehicleType);
        ResponseResult<ForecastPriceResponse> forecast = servicePriceClient.forecast(forecastPriceDTO);

        return ResponseResult.success(forecast.getData());
    }

}
