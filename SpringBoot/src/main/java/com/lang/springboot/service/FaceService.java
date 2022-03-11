package com.lang.springboot.service;

import com.lang.springboot.domain.FaceInfo;
import com.lang.springboot.domain.Message;
import org.springframework.stereotype.Service;

/**
 * @author 浪浪
 * @date 2022/3/11
 */

@Service
public interface FaceService {

    /**
     *  校验人脸
     * @param message 接收json
     */
    Message faceCheck(Message message);

    /**
     * 保存人脸信息
     *
     * @return
     */
    String insertFaceinfo(FaceInfo faceInfo);
}
