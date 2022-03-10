package com.lang.springboot.controller;

import com.lang.springboot.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Base64ToImageController {

    @RequestMapping("img")
    @ResponseBody
    public User result(@RequestBody User user){
        String name = user.getName();
        System.out.println(name);
        System.out.println(user);
        return user;
    }
}
