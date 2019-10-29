package zygh.gsc.dao;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-11-01 13:51
 */

import org.apache.ibatis.annotations.Param;
import zygh.gsc.bean.RepairOrders;

import java.util.List;
import java.util.Map;

public interface FuzzyqueryMapper {
    /*模糊查询故障损坏设备 以及未派单的设备*/
    public List<Map<String, Object>> SelectOrdersfuzzyquery(@Param("a_ip") String a_ip,
                                                            @Param("c_name") String c_name,
                                                            @Param("a_location") String a_location,
                                                            @Param("a_category") String a_category,
                                                            @Param("a_attribute") String a_attribute,
                                                            @Param("orders_orders_state") String orders_orders_state);
    /*模糊查询以接单设备 以及未派单的设备*/
    public List<RepairOrders> SelectRepairOrdersfuzzyquery(@Param("a") int a,
                                                           @Param("repair_level") String repair_level,
                                                                       @Param("repair_processing") String repair_processing,
                                                                       @Param("repair_head") String repair_head,
                                                                       @Param("repair_state") String repair_state,
                                                                       @Param("repair_data") String repair_data,
                                                                       @Param("repair_data1") String repair_data1);
}
