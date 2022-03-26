package com.lang.springboot.service.impl;

import com.arcsoft.face.FaceEngine;
import com.lang.springboot.domain.FaceInfo;
import com.lang.springboot.domain.Message;
import com.lang.springboot.service.ArcSoft;
import com.lang.springboot.service.FaceService;
import com.lang.springboot.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 浪浪
 * @date 2022/3/11
 */
@Service
public class FaceServiceImpl implements FaceService {

    @Autowired
    private ArcSoft arcSoft;

    private FaceEngine faceEngine = ArcSoft.faceEngine();

    @Override
    public Message faceCheck(Message message) {

        String base64 = message.getBase64();
        // 将base64编码转化为图片
        Utils.generateImage(base64,"/Users/taiailang/Documents/test2.jpg");
        // test 照片为你本机存储的对比照片
        float v = arcSoft.faceRecognition("/Users/taiailang/Documents/picture/1.jpg", "/Users/taiailang/Documents/picture/1.jpg", faceEngine);
        System.out.println("相似度为" + v);
        if (v == 0) {
            message.setCode(400);
            message.setMsg("请放入正确的人脸");
            message.setAcc(0);
        } else {
            message.setCode(200);
            message.setMsg("识别正确");
            message.setAcc(v);
        }
        return message;

    }

    @Override
    public String insertFaceinfo(FaceInfo faceInfo) {
        String base64Code = faceInfo.getBase64Code();
        String base64 = base64Code.replace("data:image/jpeg;base64,","");
        //处理根据日期生成目录
        try {
            String dateDirPath = ResourceUtils.getURL("classpath:").getPath()+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"/";
            //生成随机文件名
            String fileName = UUID.randomUUID().toString().replace("-","")+".jpg";

            //检查目录，没有要先创建目录，不然 new FileOutputStream() 会报 FileNotFoundException异常
            File folder = new File(dateDirPath);
            if (!folder.exists()){
                folder.mkdirs();
            }
            //合成最后临时文件路径
            String imgFilePath = dateDirPath + fileName;
            //base64编码 转 图片(base64：base64编码，imgFilePath：生成图片的路径)
            Utils.generateImage(base64, imgFilePath);

//            1、inputStream 转 ByteArrayInputStream，转成ByteArrayInputStream是因为上传阿里oss的参数需要
//            2、自定义存到阿里云oss对象存储的文件路径
//            3、调用阿里提供的SDK代码上传文件*/
            File file = new File(imgFilePath);
            FileInputStream fin = new FileInputStream(file);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = fin.read(buff, 0, 100)) > 0) {
                bout.write(buff, 0, rc);
            }
            //输出流和输入流
            bout.close();
            fin.close();





        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
