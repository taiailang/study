package com.lang.springboot.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 浪浪
 * @date 2022/3/4
 */

@Component
public class ScheduledTask {

//    @Scheduled(fixedRate = 3000)
    @Scheduled(cron = "${corn.time}")
    public void testScheduledTask(){
        System.out.println("任务执行时间："+System.currentTimeMillis());
    }


}
