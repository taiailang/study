package com.lang.springboot.config;

import com.lang.springboot.bean.OtherBean;
import com.lang.springboot.bean.SomeBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public SomeBean someBean() {
        return new SomeBean();
}

    @Bean
    public OtherBean otherBean () {
        return new OtherBean();
    }
}