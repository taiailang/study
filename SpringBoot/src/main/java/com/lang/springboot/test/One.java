package com.lang.springboot.test;

import com.alibaba.fastjson.JSONObject;
import com.lang.springboot.domain.FaceInfo;
import com.lang.springboot.domain.Message;
import com.lang.springboot.util.NumberUtils;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 浪浪
 * @date 2022/3/24
 */

public class One {
    public static void main(String[] args) {

        String s = NumberUtils.formatDouble(0);
        System.out.println(s);

        Double res = NumberUtils.avgRateDouble(573.30, 959.14);
        System.out.println(res);

        String s1 = NumberUtils.percentageFormat(573.30 / 959.14);
        System.out.println(s1);

    }

}
