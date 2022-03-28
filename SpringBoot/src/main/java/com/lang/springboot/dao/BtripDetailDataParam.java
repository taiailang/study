package com.lang.springboot.dao;

import lombok.Data;

/**
 * @author xingyi
 * @date 2021/7/20
 */
@Data
public class BtripDetailDataParam {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 企业ID
     */
    private String corpId;

    /**
     * 维度（0全维度|1部门|2项目|3成本中心|4个人）
     */
    private Integer dimension;

    /**
     * 维度名称
     */
    private String dimensionName;

    /**
     * 类目（0全类目|1机|2酒|3火|4用车）
     */
    private Integer category;

    /**
     * 聚合的小分类
     */
    private Integer type;

    /**
     * 聚合的小分类(一次查多个，给节省构成使用，","分隔)
     */
    private String typeStr;

    /**
     * 结算时间-起始
     */
    private String settleTimeStart;

    /**
     * 结算时间-结束
     */
    private String settleTimeEnd;

    /**
     * 分页起始值: pageIndex = (pageStart - 1) * pageSize
     */
    private Integer pageIndex;

    /**
     * 分页大小
     */
    private Integer pageSize;

    /**
     * 排序字段
     */
    private String columnName;

    /**
     * 分组字段
     */
    private String groupColumnName;

    /**
     * 排序类型，asc升序，desc降序
     */
    private String orderType;

    /**
     * 卡片id
     */
    private Integer cardId;

}
