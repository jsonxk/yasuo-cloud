package com.yasuo;


import java.util.ServiceLoader;

/**
 * @Description:
 * @Author: xk
 * @Date: 2022/12/30 15:37
 **/
public class LogImpl implements Log {

    public void info(String info) {
        System.out.println(info);
    }

    public static void main(String[] args) throws Exception {
        ServiceLoader<Log> serviceLoader = ServiceLoader.load(Log.class);
        serviceLoader.forEach(item -> {
            item.info("test");
        });
    }
}
