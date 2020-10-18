package com.ttdys.web.controller;

import com.ttdys.common.http.Response;
import com.ttdys.data.entity.User;
import com.ttdys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/list")
    public Response<List<User>> listAll() {
        User user = (User) redisTemplate.opsForValue().get("a");
        System.out.println(user.getUsername());
        return userService.listAll();
    }


}
