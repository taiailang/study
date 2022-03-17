//package com.lang.springboot.util;
//
//import com.aliyun.oss.OSS;
//import com.lang.springboot.config.OssConstant;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//
//@Component
//public class OssUpload {
//
//    @Autowired
//    private OssConstant ossConstant;
//
//    public void oss(String dateFormat, String fileName, ByteArrayInputStream bin) throws IOException {
//        String objectName = dateFormat + fileName;
//
//        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(
//                ossConstant.getEndpoint(),
//                ossConstant.getAccessKeyId(),
//                ossConstant.getAccessKeySecret());
//
//        // 上传文件到指定的存储空间（bucketName）并将其保存为指定的文件名称（objectName）。
//        ossClient.putObject(ossConstant.getBucketName(), objectName, bin);
//
//        // 关闭OSSClient。
//        ossClient.shutdown();
//    }
//}
//
//
