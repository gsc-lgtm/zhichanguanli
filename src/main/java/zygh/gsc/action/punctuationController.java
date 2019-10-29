package zygh.gsc.action;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-08-13 16:05
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zygh.gsc.bean.Assets;
import zygh.gsc.bean.Orders;
import zygh.gsc.dao.punctuationMapper;
import zygh.gsc.service.punctuationService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/asset")
public class punctuationController {

    @Autowired
    private punctuationService punctuationService;

    /**
     * 查询经纬度在地图上显示
     *
     * @param [response]
     * @return java.util.Map<java.lang.String       ,       java.util.List       <       java.lang.Object>>
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:09
     */

    @RequestMapping("/punctuationlist")
    @ResponseBody
    public Map<String, List<Object>> select(String name,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        List punctuationlist = punctuationService.punctuationchaxun(name);
        map.put("punctuationlist", punctuationlist);
        return map;
    }


    /**
     * 查询损坏的设备
     * @param response
     * @return
     */
    @RequestMapping("/sunhuaichaxun")
    @ResponseBody
    public Map<String, List<Object>> sunhuaichaxun(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        List sunhuaichaxun = punctuationService.sunhuaichaxun();
        map.put("sunhuaichaxun", sunhuaichaxun);
        return map;
    }

    /**
     * 根据查询损坏的设备添加到数据待派单表里
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/ordersSelect")
    @ResponseBody
    public Map<String, List<Assets>>  ordersselect(HttpServletResponse response) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map<String, List<Assets>> map = new HashMap<String, List<Assets>>();
        List<Assets> sunhuai=punctuationService.sunhuaichaxun();//获取损坏的所有的设备
        // start 获取当前的时间 跟设备掉电的时间跟当前时间进行对比获取掉电了几天几时几分几秒
       long a =System.currentTimeMillis();//获取当前时间戳
        String huai = "2018-10-29 11:01:36";
        SimpleDateFormat aa = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = a - aa.parse(huai).getTime();
        // 计算差多少天
        long day = diff / nd;
	    // 计算差多少小时
        long hour = diff % nd / nh;
	    // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        String dangqian=day + "天" + hour + "小时" + min + "分钟"+sec+"秒";
       List <Orders> orders1= punctuationService.Ordersselect();
        // start 将设备掉电时间的分 对比当前时间的分
       long dangqian1= aa.parse(huai).getTime()/ nd;
       long dangqian2= a/ nd;
        // end 将设备掉电时间的分 对比当前时间的分
        // end 获取当前的时间 跟设备掉电的时间跟当前时间进行对比获取掉电了几天几时几分几秒
       //start 将 orders , shunkuai 两个数组里面的a_id 取出来存放到一个新的List 集合里面。
       List<String> orderslao=new ArrayList<String>();
       for(int k=0;k<orders1.size();k++){
           orderslao.add(orders1.get(k).getA_id()+"");
       }
        List<String> sunhuai1=new ArrayList<String>();
        for(int k=0;k<sunhuai.size();k++){
            sunhuai1.add(sunhuai.get(k).getA_id()+"");
        }
        //end  将 orders , shunkuai 两个数组里面的a_id 取出来存放到一个新的List 集合里面。
            for(int i=0;i<sunhuai.size();i++) {
                if(orders1 ==null || orders1.size()==0){
                    Orders orders = new Orders();
                    orders.setA_id(sunhuai.get(i).getA_id());
                    orders.setOrders_time(dangqian);
                    int tianjiacheng = punctuationService.oredrsinsert(orders);
                }else{
                    //判断新的损坏在旧的损坏表中是否出现，如果出现结束循环，不存在添加
                    int con=Collections.frequency(orderslao,sunhuai.get(i).getA_id()+"");
                    if(con>0){
                        continue;
                    }else{
                        Orders orders=new Orders();
                        orders.setA_id(sunhuai.get(i).getA_id());
                        orders.setOrders_time(dangqian);
                        int tianjiacheng= punctuationService.oredrsinsert(orders);
                    }
                }
            }
            //新的设备损坏表对比旧的损坏表，将旧损坏表已经修好的设备删除
                List<String> C = new ArrayList<String>();
                C.addAll(orderslao);
                C.removeAll(sunhuai1);
                for(int i=0;i<C.size();i++){
                    System.out.println(C);
                    punctuationService.oredrsdelete(Integer.parseInt(C.get(i)));
                }
                //判断时间是否大于30分钟如果大于就故障
                for(int c=0;c<orders1.size();c++){
                    if(orders1.get(c).getOrders_state().equals("故障")==false){
                        if(dangqian2-dangqian1  >-1){
                                punctuationService.oredrsupdate(orders1.get(c).getA_id());
                        }
                    }
                }
                //实时修改损坏设备的损坏时间
                    for(int c=0;c<orders1.size();c++){
                        punctuationService.Oredrsupdatetime(dangqian,orders1.get(c).getOrders_id());
                    }
        List orders2= punctuationService.Ordersassetsselect();
        map.put("orders2",orders2);
        return map;
    }





}
