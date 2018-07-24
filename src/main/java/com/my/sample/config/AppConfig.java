package com.my.sample.config;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger2Doc // 开启Swagger2，自动生成文档，Url：/swagger-ui.html
@EnableConfigurationProperties(value = {AppProperties.class})
public class AppConfig {

}
