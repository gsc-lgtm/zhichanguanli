package zygh.gsc.dao;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-10-26 18:23
 */

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import zygh.gsc.bean.Assets;
import zygh.gsc.bean.RepairOrders;

import java.util.List;
import java.util.Map;

@Repository
public interface RepairOrdersMapper {
    //查询所属系统
    public List selectCom();
    //查询所属系统的子系统
    public List selectsubsystem(String name);
    //发布工单
    public int  insertRepairorders(RepairOrders repairOrders);

    //查询所属公司以及公司负责人
    public List<Map<String,Object>> selectCompany(String name);

    //查询所有分配中的工单
    public List selectRepairOrders(String name);

    //发布工单后修改状态
    public int updatestate(int orders_id);

   //接单后 根据id 填写原因 以及更改 接单变为处理中
    public int updateRepairOrders(@Param("repair_completiontime") String repair_completiontime, @Param("repair_id") int repair_id, @Param("repair_eventhandler") String repair_eventhandler, @Param("repair_note") String repair_note);

    //接单后 根据id 填写原因 以及更改 接单变为结案
    public int updateRepairOrdersResults(@Param("repair_id") int repair_id,@Param("repair_completiondate") String repair_completiondate, @Param("repair_eventreason") String repair_eventreason, @Param("repair_dealresults") String repair_dealresults);

    public List<RepairOrders> Selectdealwith(@Param("name") String name);
    public List selectdealwithCompany();
}
