package com.my.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Mongo配置
 */
@Configuration
@EnableMongoRepositories(basePackages = {"com.my.sample.dao.repository"})
public class MongoConfig {

    @Resource
    MappingMongoConverter converter;

    @PostConstruct
    public void init() {
        converter.setTypeMapper(defaultMongoTypeMapper());
    }

    /**
     * 消除自动产生的_class属性
     *
     * @return typeMapper
     */
    @Bean
    public DefaultMongoTypeMapper defaultMongoTypeMapper() {
        return new DefaultMongoTypeMapper(null, converter.getMappingContext());
    }

}
