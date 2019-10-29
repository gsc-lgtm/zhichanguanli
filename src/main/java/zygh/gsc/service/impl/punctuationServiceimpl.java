package zygh.gsc.service.impl;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-08-24 14:30
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zygh.gsc.bean.Assets;
import zygh.gsc.bean.Orders;
import zygh.gsc.dao.punctuationMapper;
import zygh.gsc.service.punctuationService;


import java.util.List;
import java.util.Map;

@Service("punctuationService")
public class punctuationServiceimpl implements punctuationService {
    @Autowired
    private punctuationMapper punctuation;

    public List<Assets> sunhuaichaxun() {
        return punctuation.sunhuaichaxun();
    }

    /**
     * 查询经纬度在地图上显示标点
     *
     * @param []
     * @return java.util.List<zygh.gsc.bean.Assets>
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:08
     */
    public List<Assets> punctuationchaxun(String name) {
        return punctuation.punctuationchaxun(name);
    }

    public int oredrsinsert(Orders orders) {
        return punctuation.oredrsinsert(orders);
    }

    public List<Orders> Ordersselect() {
        return punctuation.Ordersselect();
    }

    public List<Map<String, Object>> Ordersassetsselect() {
        return punctuation.Ordersassetsselect();
    }

    public int oredrsdelete(int con1) {
        return punctuation.oredrsdelete(con1);
    }

    public int oredrsupdate(int a_id) {
        return punctuation.oredrsupdate(a_id);
    }

    public int Oredrsupdatetime(String dangqian,int orders_id) {
        return punctuation.Oredrsupdatetime(dangqian,orders_id);
    }

}
