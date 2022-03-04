package com.lang.springboot.config;

import com.lang.springboot.bean.OtherBean;
import com.lang.springboot.controller.LoginController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author 浪浪
 * @date 2022/3/3
 */
//@ImportResource("com/lang/applicationContext.xml")
@ComponentScan(basePackages = "com.lang")
@Configuration
public class LoginConfig{
    @Bean
    public LoginController loginController () {
        return new LoginController();
    }
}
