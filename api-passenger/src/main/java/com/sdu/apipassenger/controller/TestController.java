package com.sdu.apipassenger.controller;

import com.sdu.internalcommon.dto.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LHP
 * @date 2023-07-10 0:58
 * @description api-passenger测试控制器
 */

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "test api passenger";
    }

    /**
     * 需要有token
     * @return
     */
    @GetMapping("/authTest")
    public ResponseResult authTest() {
        return ResponseResult.success("auth test");
    }

    /**
     * 不需要有token
     * @return
     */
    @GetMapping("/noAuthTest")
    public ResponseResult noAuthTest() {
        return ResponseResult.success("no auth test");
    }
}
