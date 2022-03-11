package com.lang.springboot.domain;

import lombok.Data;

/**
 * @author 浪浪
 * @date 2022/3/11
 */

@Data
public class FaceInfo {

    /**
     * 姓名
     */
    private String name;

    /**
     * 学号
     */
    private String studentNumber;

    /**
     * 手机号
     */
    private String number;

    /**
     * 班级
     */
    private String classes;

    /**
     * base64编码
     */
    private String base64Code;


}
