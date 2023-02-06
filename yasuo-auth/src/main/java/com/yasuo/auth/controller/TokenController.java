package com.yasuo.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: xk
 * @Date: 2023/2/6 14:51
 **/
@RestController
@RequestMapping("/token")
public class TokenController {

    @GetMapping("/get")
    public String get(String token){
        return token;
    }
}
