package com.sdu.servicemap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LHP
 * @date 2023-07-12 1:21
 * @description
 */

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test service-map";
    }

}
