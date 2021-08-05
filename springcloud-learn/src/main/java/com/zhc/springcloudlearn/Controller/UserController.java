package com.zhc.springcloudlearn.Controller;

import com.zhc.springcloudlearn.Dao.UserRepository;
import com.zhc.springcloudlearn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UserController {

    @Value("${server.port}")
    private Integer serverPort;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return this.userRepository.findById(id);
    }

    @GetMapping("/port")
    public Integer getPort() {
        return serverPort;
    }
}
