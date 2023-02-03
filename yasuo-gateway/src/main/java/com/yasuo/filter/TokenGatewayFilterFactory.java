package com.yasuo.filter;

import com.alibaba.fastjson2.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Description:
 * @Author: xk
 * @Date: 2023/2/2 10:31
 **/
@Component
@Slf4j
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenGatewayFilterFactory.Config> {

    //组织id
    private final static String ORIGIN_ID = "origin_id";

    public TokenGatewayFilterFactory() {
        super(Config.class);
    }

    public GatewayFilter apply(TokenGatewayFilterFactory config) {
        return null;
    }

    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {
            if (config.isOrigin.equals("true")) {
                ServerHttpRequest request = exchange.getRequest();
                HttpHeaders httpHeaders = request.getHeaders();
                String originId = httpHeaders.getFirst(ORIGIN_ID);
                originId = StringUtils.isEmpty(originId) ? request.getQueryParams().getFirst(ORIGIN_ID) : originId;
                ServerHttpResponse response = exchange.getResponse();
                if (StringUtils.isEmpty(originId)) {
                    Map<String, Object> code = new HashMap<>();
                    code.put("code", 401);
                    code.put("msg", "权限不足，组织信息不存在！");
                    DataBuffer dataBuffer = response.bufferFactory().wrap(JSON.toJSONString(code).getBytes());
                    //response.setStatusCode(HttpStatus.UNAUTHORIZED); // 设置响应状态码 401， 200， 503等等
                    response.getHeaders().add(HttpHeaders.CONTENT_TYPE, "application/json");
                    return response.writeWith(Mono.error(new ResponseStatusException(HttpStatus.BAD_GATEWAY, "origin_id不存在")));
                    //response.setComplete()
                }
            }
            //执行下一个过滤器
            return chain.filter(exchange);
        };
    }

    public GatewayFilter apply(String routeId, TokenGatewayFilterFactory.Config config) {
        return super.apply(routeId, config);
    }

    public String name() {
        return super.name();
    }

    public ShortcutType shortcutType() {
        return super.shortcutType();
    }

    /**
     * 返回配置文件参数
     */
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("isOrigin");
    }

    public String shortcutFieldPrefix() {
        return super.shortcutFieldPrefix();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Config {

        private String isOrigin;
    }
}
