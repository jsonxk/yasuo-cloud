package com.yasuo.common.core.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description:
 * @Author: xk
 * @Date: 2022/12/20 17:17
 **/
@Setter
@Getter
public class Result<T> implements Serializable {

    /**
     * 状态码
     */
    private int code;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    public Result<T> fail() {
        return resultBody(HttpStatusEnum.FAIL.getCode(), HttpStatusEnum.FAIL.getMsg(), null);
    }

    public Result<T> fail(String msg) {
        return resultBody(HttpStatusEnum.FAIL.getCode(), msg, null);
    }

    public Result<T> fail(T data) {
        return resultBody(HttpStatusEnum.FAIL.getCode(), HttpStatusEnum.FAIL.getMsg(), data);
    }

    public Result<T> fail(int code, String msg) {
        return resultBody(code, msg, null);
    }

    public Result<T> fail(int code, String msg, T data) {
        return resultBody(code, msg, data);
    }

    public Result<T> success() {
        return resultBody(HttpStatusEnum.SUCCESS.getCode(), HttpStatusEnum.SUCCESS.getMsg(), null);
    }

    public Result<T> success(String msg) {
        return resultBody(HttpStatusEnum.SUCCESS.getCode(), msg, null);
    }

    public Result<T> success(T data) {
        return resultBody(HttpStatusEnum.SUCCESS.getCode(), HttpStatusEnum.SUCCESS.getMsg(), data);
    }

    public Result<T> SUCCESS(int code, String msg) {
        return resultBody(code, msg, null);
    }

    public Result<T> SUCCESS(int code, String msg, T data) {
        return resultBody(code, msg, data);
    }

    private Result<T> resultBody(int code, String msg, T data) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

}
