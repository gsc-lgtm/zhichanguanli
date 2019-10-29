package zygh.gsc.service;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-08-24 14:27
 */

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import zygh.gsc.bean.Assets;
import zygh.gsc.bean.Orders;

import java.util.List;
import java.util.Map;

@Repository
public interface punctuationService {
    /**
     * 查询经纬度在地图上显示标点
     *
     * @param []
     * @return java.util.List<zygh.gsc.bean.Assets>
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:08
     */

    public List<Assets> punctuationchaxun(String name);
    public List<Assets> sunhuaichaxun();
    public int oredrsinsert (Orders orders);
    //查询Orders是否存在相同的id
    public List<Orders> Ordersselect();
    public List<Map<String, Object>> Ordersassetsselect();

    public int oredrsdelete(int  con1);

    public int oredrsupdate(int a_id);

    public int Oredrsupdatetime( String dangqian, int orders_id);
}
