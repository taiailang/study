package com.lang.springboot.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author 浪浪
 * @date 2022/2/28
 */

@Data
@Configuration
@Component
@PropertySource(value = {"classpath:application.properties"},encoding="utf-8")
public class User {


    @Value("${name}")
    private String name;

    @Value("${age}")
    private Integer age;

    public String getNameAndAge(){
        return name+age;
    }
}
