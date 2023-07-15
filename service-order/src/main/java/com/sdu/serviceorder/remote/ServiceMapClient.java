package com.sdu.serviceorder.remote;

import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.internalcommon.response.TerminalResponse;
import com.sdu.internalcommon.response.TrsearchResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author LHP
 * @date 2023-07-14 22:45
 * @description
 */

@FeignClient("service-map")
public interface ServiceMapClient {

    @RequestMapping(method = RequestMethod.POST,value = "/terminal/aroundsearch")
    public ResponseResult<List<TerminalResponse>> terminalAroundSearch(@RequestParam String center , @RequestParam Integer radius);

    @RequestMapping(method = RequestMethod.POST, value = "/terminal/trsearch")
    public ResponseResult<TrsearchResponse> trsearch(@RequestParam String tid, @RequestParam Long starttime, @RequestParam Long endtime);

}
