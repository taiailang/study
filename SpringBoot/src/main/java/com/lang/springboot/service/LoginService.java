package com.lang.springboot.service;

import com.lang.springboot.dao.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginDAO loginDAO;


    public void login() {
        loginDAO.login();
    }
}