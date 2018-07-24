package com.my.sample.config;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@MapperScan(basePackages = {"com.my.sample.mapper"})  // mybatis自动描包
@EnableSwagger2Doc // 开启Swagger2，自动生成文档，Url：/swagger-ui.html
@EnableConfigurationProperties(value = {AppProperties.class})
@EnableAsync
public class AppConfig {

}
