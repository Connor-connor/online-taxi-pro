package com.sdu.serviceprice.remote;

import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.internalcommon.request.ForecastPriceDTO;
import com.sdu.internalcommon.response.DirectionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author LHP
 * @date 2023-07-12 9:05
 * @description
 */

@FeignClient("service-map")
public interface ServiceMapClient {

    @RequestMapping(method = RequestMethod.GET, value = "/direction/driving")
    public ResponseResult<DirectionResponse> direction(@RequestBody ForecastPriceDTO forecastPriceDTO);

}
