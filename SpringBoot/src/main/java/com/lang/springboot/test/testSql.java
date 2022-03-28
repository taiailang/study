package com.lang.springboot.test;

import com.lang.springboot.dao.BtripDetailDataParam;
import org.apache.commons.lang3.StringUtils;

/**
 * @author 浪浪
 * @date 2022/3/21
 */
public class testSql {

    public final static String columnList="SUM(flight_count) flight_count, SUM(hotel_count) hotel_count, " +
            "SUM(train_count) train_count, SUM(car_count) car_count, " +
            "SUM(all_count) all_count";


    public static void main(String[] args) {
        BtripDetailDataParam param=new BtripDetailDataParam();
//        param.setGroupColumnName("depart_name");
        param.setTableName("btrip_brain_carbon_day_data");
        param.setCorpId("ding3cb4e74a88d5a55535c2f4657eb6378f");
        param.setSettleTimeStart("2022-01-01 00:00:00");
        param.setSettleTimeEnd("2022-03-23 00:00:00");
//        param.setColumnName("all_count");
//        param.setOrderType("desc");
//        param.setPageIndex(1);
//        param.setPageSize(10);
        sql(param);

    }

    public static void sql(BtripDetailDataParam param) {

        StringBuilder sb=new StringBuilder();
        sb.append("select").append(" ");
        if (StringUtils.isNotEmpty(param.getGroupColumnName())){
            sb.append(param.getGroupColumnName()).append(",").append(" ");
        }
        sb.append(columnList).append(" ");
        sb.append("from").append(" ").append(param.getTableName()).append(" ");
        sb.append("where").append(" ");
        sb.append("corp_id").append(" = ").append('\'').append(param.getCorpId()).append('\'').append(" ");
        sb.append("and settle_time >= ").append('\'').append(param.getSettleTimeStart()).append('\'').append(" ");
        sb.append("and settle_time <= ").append('\'').append(param.getSettleTimeEnd()).append('\'').append(" ");
        if (StringUtils.isNotEmpty(param.getGroupColumnName())){
            sb.append("group by").append(" ").append(param.getGroupColumnName()).append(" ");
        }
        if (StringUtils.isNotEmpty(param.getColumnName())){
            sb.append("order by").append(" ").append(param.getColumnName()).append(" ").append(param.getOrderType()).append(" ");
        }
        if (param.getPageIndex() != null && param.getPageSize() != null) {
            sb.append("Limit ").append((param.getPageIndex() - 1) * param.getPageSize()).append(",").append(
                    param.getPageSize());
        }
        System.out.println(sb);
    }
}
