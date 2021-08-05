package com.zhc.springcloudlearnconsumer.Controller;

import com.zhc.springcloudlearnconsumer.entity.User;
import com.zhc.springcloudlearnconsumer.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/movies")
@RestController
public class MovieController {
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        // 这里用到了RestTemplate的占位符能力
//        User user = this.restTemplate.getForObject("http://microservice-provider-user/users/{id}", User.class, id);
//        // ...电影微服务的业务...
//        return user;
        return userFeignClient.findById(id);
    }

//    @GetMapping("/port")
//    public Integer getPort() {
//        return this.restTemplate.getForObject("http://microservice-provider-user/users/port", Integer.class);
//    }
}