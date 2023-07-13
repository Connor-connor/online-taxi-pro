package com.sdu.servicemap.service;

import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.internalcommon.response.TrackResponse;
import com.sdu.servicemap.remote.TrackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LHP
 * @date 2023-07-13 23:28
 * @description
 */

@Service
public class TrackService {

    @Autowired
    TrackClient trackClient;

    public ResponseResult<TrackResponse> add(String tid){

        return trackClient.add(tid);
    }
}
