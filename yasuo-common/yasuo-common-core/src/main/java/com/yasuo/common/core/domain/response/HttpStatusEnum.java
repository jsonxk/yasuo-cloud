package com.yasuo.common.core.domain.response;

import com.yasuo.common.core.constants.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Description:
 * @Author: xk
 * @Date: 2022/12/20 17:54
 **/
@Getter
@ToString
@AllArgsConstructor
public enum HttpStatusEnum {

    SUCCESS(HttpStatus.HTTP_OK, "成功"),

    FAIL(HttpStatus.HTTP_INTERNAL_ERROR, "系统异常");

    private int code;

    private String msg;
}
