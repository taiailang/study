package com.lang.springboot.controller;

import com.lang.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@RequestMapping("/user")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public void login() {
        loginService.login();
    }
}