package com.lang.springboot.service.impl;

import com.lang.springboot.domain.User;
import com.lang.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 浪浪
 * @date 2022/2/25
 */

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private User user;

    @Override
    public String test() {
        return "hello world";
    }

    @Override
    public String testAnnotation() {

        return user.getNameAndAge();
    }
}
