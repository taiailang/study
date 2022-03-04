package com.lang.springboot.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author 浪浪
 * @date 2022/3/4
 */

@Component
@JobHandler(value = "helloJobHandler")
public class HelloJobHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        System.out.println("XXL-JOB, Hello World.");
        return SUCCESS;
    }
}
