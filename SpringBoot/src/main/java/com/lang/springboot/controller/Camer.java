package com.lang.springboot.controller;

import com.arcsoft.face.FaceEngine;
import com.lang.springboot.domain.Msg;
import com.lang.springboot.service.ArcSoft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


@Controller
public class Camer {

    @Autowired
    private ArcSoft arcSoft;
    private FaceEngine faceEngine = ArcSoft.faceEngine();

    @Autowired
    private Msg msg;

//    @CrossOrigin
    @ResponseBody
    @RequestMapping("/img")
    public Msg img(@RequestBody Msg msg) {
        int code = msg.getCode();
        System.out.println(code);
        String base64 = msg.getBase64();
        //记得去除：data:image/jpg;base64,
        BASE64Decoder decoder = new BASE64Decoder();
        boolean b = generateImage(base64,"D:\\test2.jpg");
//        test 照片为你本机存储的对比照片
        float v = arcSoft.faceRecognition("D:\\test2.jpg", "https://lang-feng.oss-cn-hangzhou.aliyuncs.com/%E6%AD%A6.jpg", faceEngine);
        System.out.println("相似度为" + v);
        if (v == 0) {
            msg.setCode(400);
            msg.setMsg("请放入正确的人脸");
            msg.setAcc(0);
        } else {
            msg.setCode(200);
            msg.setMsg("识别正确");
            msg.setAcc(v);
        }
        return msg;
    }

    public boolean generateImage(String imgStr,String imgFilePath) {
        if(imgStr == null) {
            return false;
        }
        byte[] b;
        try {
            b = new BASE64Decoder().decodeBuffer(imgStr);
            for (int i = 0; i < b.length; i++) {
                if(b[i]<0) {
                    b[i]+=256;
                }
            }
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
