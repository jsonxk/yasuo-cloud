package com.yasuo.auth.controller;

import com.yasuo.auth.entity.Test;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: xk
 * @Date: 2023/2/6 14:51
 **/
@RestController
@RequestMapping("/token")
@Api(tags = "Token")
public class TokenController {

    @GetMapping("/get")
    @ApiOperation(value = "获取token")
    @ResponseBody
    public Test get(@RequestBody Test t) {
        return t;
    }


}
