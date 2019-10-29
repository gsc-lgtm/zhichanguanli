package zygh.gsc.dao;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-08-13 16:06
 */


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import zygh.gsc.bean.Assets;
import zygh.gsc.bean.Orders;

import java.util.List;
import java.util.Map;

@Repository
public interface punctuationMapper {
    /**
     * 查询经纬度在地图上显示标点
     *
     * @param []
     * @return java.util.List<zygh.gsc.bean.Assets>
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:08
     */

    public List<Assets> punctuationchaxun(String name);

    /**
     * 查询损坏的设备
     * @return
     */
    public List<Assets> sunhuaichaxun();

    /**
     * 根据查询损坏的设备添加到数据待派单表里
     * @return
     * @throws Exception
     */
    public int oredrsinsert (Orders orders);
    public List<Orders> Ordersselect();
    public List<Map<String, Object>> Ordersassetsselect();
    public int oredrsdelete(int con1);
    public int oredrsupdate(int a_id);
    public int Oredrsupdatetime(@Param("dangqian") String dangqian, @Param("orders_id") int orders_id);
}
