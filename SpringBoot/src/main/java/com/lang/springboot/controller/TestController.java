package com.lang.springboot.controller;

import com.lang.springboot.bean.AsyncTasks;
import com.lang.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 浪浪
 * @date 2022/2/25
 */

@Controller
public class TestController {

    @Autowired
    private AsyncTasks asyncTasks;

    @Autowired
    private TestService testService;

    @RequestMapping("t")
    @ResponseBody
    public String test() {
        String str = testService.test();
        return str;
    }
}
