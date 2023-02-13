package com.yasuo.auth.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author: xk
 * @Date: 2023/2/13 15:53
 **/
@Setter
@Getter
@ApiModel(value = "ddd")
public class Test {

    @ApiModelProperty(value = "sss")
    private String t;
}
