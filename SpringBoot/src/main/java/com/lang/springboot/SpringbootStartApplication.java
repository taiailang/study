package com.lang.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 浪浪
 * @date 2022/2/25
 */

@EnableAsync //异步调用
@EnableScheduling //开启定时任务
@SpringBootApplication  // 启动类
@EnableTransactionManagement  //开通事务EnableTransactionManagement
public class SpringbootStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStartApplication.class, args);
    }
}




