package com.lang.springboot.util;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
public class Utils {
    //图片转换
    public static File getFileByUrl(String fileUrl) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        BufferedOutputStream stream = null;
        InputStream inputStream = null;
        File file = null;
        String suffix = "";
        try {
            suffix = fileUrl.split("\\.")[1];
            URL imageUrl = new URL(fileUrl);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            inputStream = conn.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            file = File.createTempFile("pattern", "." + suffix);
            log.info("临时文件创建成功={}", file.getCanonicalPath());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            stream = new BufferedOutputStream(fileOutputStream);
            stream.write(outStream.toByteArray());
        } catch (Exception e) {
            log.error("创建人脸获取服务器图片异常", e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (stream != null) {
                    stream.close();
                }
                outStream.close();
            } catch (Exception e) {
                log.error("关闭流异常", e);
            }
        }
        return file;
    }

    public boolean generateImage(String imgStr, String imgFilePath) {
        if (imgStr == null) {
            return false;
        }
        byte[] b;
        try {
            b = new BASE64Decoder().decodeBuffer(imgStr);
            for (int i = 0; i < b.length; i++) {
                if (b[i] < 0) {
                    b[i] += 256;
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
