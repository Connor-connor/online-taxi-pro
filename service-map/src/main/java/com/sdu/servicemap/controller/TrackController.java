package com.sdu.servicemap.controller;

import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.servicemap.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LHP
 * @date 2023-07-13 23:27
 * @description
 */

@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    TrackService trackService;

    @PostMapping("/add")
    public ResponseResult add(String tid){

        return trackService.add(tid);
    }
}
