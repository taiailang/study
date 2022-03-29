package com.lang.springboot.util;

import io.netty.util.internal.StringUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 数字类工具类
 *
 * @author 浪浪
 * @date 2022/3/25
 */
public class NumberUtils {


    /**
     * 拆解判断Integer为空的，赋空值
     */
    public static Integer isIntegerEmpty(Integer count) {
        if (null == count) {
            count = 0;
        }
        return count;
    }

    /**
     * 判断Long为空的，赋0值
     */
    public static Long isLongEmpty(Long amount) {
        if (null == amount) {
            amount = 0L;
        }
        return amount;
    }

//    /**
//     * 判断String空的，赋--值
//     */
//    public static String isStringEmpty(String str) {
//        if (StringUtil.isBlank(str)) {
//            str = TripReportEmptyDataEnum.EMPTY_DATA.getName();
//        }
//        return str;
//    }

    /**
     * 判断Double为空的，赋0值
     */
    public static Double isDoubleEmpty(Double amount) {
        if (null == amount || amount == 0) {
            amount = (double) 0;
        }
        return amount;
    }

    /**
     * 重写科学记数法：保留两位小数，且保留千分制
     */
    public static String formatDouble(double d) {
        //保留两位小数并展示千分位符
        DecimalFormat df1 = new DecimalFormat("##,##0");
        String format = df1.format(d);
        return format;
    }

    /**
     * double保留两位小数
     *
     * @param a
     * @return
     */
    public static double doubleToScale(double a) {
        BigDecimal b = new BigDecimal(a);
        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        return f1;
    }

    /**
     * 计算平均数，返回Double，保留两位小数
     */
    public static Double avgRateDouble(Long molecule, Double denominator) {
        if (denominator == 0) {
            return (double) 0;
        }

        BigDecimal avgRate = new BigDecimal(molecule).divide(new BigDecimal(denominator), 2, BigDecimal.ROUND_HALF_DOWN);
        if (avgRate == null) {
            avgRate = new BigDecimal(0);
        }

        return Double.parseDouble(avgRate.toString());
    }

    /**
     * 计算平均数，返回Double，保留四位小数
     */
    public static Double avgRateDouble(Double molecule, Double denominator) {
        if (denominator == 0) {
            return (double) 0;
        }

        BigDecimal avgRate = new BigDecimal(molecule).divide(new BigDecimal(denominator), 4, BigDecimal.ROUND_HALF_DOWN);
        if (avgRate == null) {
            avgRate = new BigDecimal(0);
        }

        return Double.parseDouble(avgRate.toString());
    }


    /**
     * 小数转换成百分比，保留两位小数
     * 0.1234 转成 12.34%
     */
    public static String percentageFormat(double format) {
        DecimalFormat df = new DecimalFormat("0.00%");
        String percentage = df.format(format);

        return percentage;
    }

    /**
     * 计算两个占比的相互百分比
     */
    public static BigDecimal getRateByDoubleAvgRate(double avgRateMolecule, double avgRateDenominator) {
        if (avgRateDenominator == 0) {
            return null;
        }
        return new BigDecimal(avgRateMolecule).divide(new BigDecimal(avgRateDenominator), 4, BigDecimal.ROUND_HALF_DOWN);
    }
}
