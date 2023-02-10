package com.yasuo.common.swagger;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: xk
 * @Date: 2023/2/10 17:05
 **/
@Configuration
@EnableOpenApi
@EnableKnife4j
@EnableAutoConfiguration
@ConditionalOnProperty(name = "swagger.enable", value = "true")
public class SwaggerConfigure {

    /**
     * 默认的排除路径，排除Spring Boot默认的错误处理路径和监控
     */
    private static final List<String> DEFAULT_EXCLUDE_PATH = Arrays.asList("/error", "/actuator/**");

    private static final String BASE_PATH = "/**";

    @Bean
    public Docket docket(SwaggerProperties swaggerProperties) {

        if (CollectionUtils.isEmpty(swaggerProperties.getBasePath())) {
            swaggerProperties.getBasePath().add(BASE_PATH);
        }
        if (CollectionUtils.isEmpty(swaggerProperties.getExcludePath())) {
            swaggerProperties.setExcludePath(DEFAULT_EXCLUDE_PATH);
        }

        ApiSelectorBuilder apiSelectorBuilder = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo(swaggerProperties)).select();
        swaggerProperties.getBasePath().forEach(item -> apiSelectorBuilder.paths(PathSelectors.ant(item)));
        swaggerProperties.getExcludePath().forEach(item -> apiSelectorBuilder.paths(PathSelectors.ant(item).negate()));
        return apiSelectorBuilder.build();
    }

    private ApiInfo apiInfo(SwaggerProperties swaggerProperties) {
        return new ApiInfoBuilder()
                .description(swaggerProperties.getDescription())
                .license(swaggerProperties.getLicense())
                .licenseUrl(swaggerProperties.getLicenseUrl())
                .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
                .title(swaggerProperties.getTitle())
                .version(swaggerProperties.getVersion())
                .build();
    }
}
