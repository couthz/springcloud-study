package com.zhc.springcloudlearnconsumer.service;

import com.zhc.springcloudlearnconsumer.config.UserFeignConfig;
import com.zhc.springcloudlearnconsumer.entity.User;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 对生产者无侵入的写法, 从Resttemplate的命令式变为声明式，怎么做变为做什么
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}

