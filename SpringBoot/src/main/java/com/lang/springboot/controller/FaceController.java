package com.lang.springboot.controller;

import com.arcsoft.face.FaceEngine;
import com.lang.springboot.domain.FaceInfo;
import com.lang.springboot.domain.Message;
import com.lang.springboot.service.FaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FaceController {

    // 参考链接 https://www.codeleading.com/article/61615876530/

    @Autowired
    private FaceService faceService;

    @ResponseBody
    @RequestMapping("/img")
    public Message faceCheck(@RequestBody Message message) {

        Message res = faceService.faceCheck(message);

        return res;
    }

    @ResponseBody
    @RequestMapping("/faceInfo")
    public String insertFaceInfo(@RequestBody FaceInfo faceInfo){


        return "保存成功！！！";
    }

}
