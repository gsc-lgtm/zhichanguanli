package zygh.gsc.action;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-11-07 17:01
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zygh.gsc.bean.*;
import zygh.gsc.dao.StatisticalMapper;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/asset")
public class StatisticalController {
    @Autowired
    private StatisticalMapper statisticalMapper;

    /**
     * 计算出每种设备的状态值
     * @param response
     * @return
     */
    @RequestMapping("SelectStatistical")
    @ResponseBody
    public Map SelectStatistical(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        //查询资产的 a_attribute 有去重 有几种不重复的类型
        List<Assets> SelectAssetsshebie = statisticalMapper.SelectAssetsshebie();
        List selectStatistical = new ArrayList();
        for (int i = 0; i < SelectAssetsshebie.size(); i++) {
            //查询出 总数  未启用  正常  损坏  派单数  宕机 每个的数量
            List selectStatistical1 = statisticalMapper.SelectStatistical(SelectAssetsshebie.get(i).getA_attribute());
            selectStatistical.add(selectStatistical1);
        }
        map.put("selectStatistical", selectStatistical);
        return map;
    }

    /**
     * 获取当前的设备完好率
     * @param response
     * @return
     */
    @RequestMapping("Selectpipe")
    @ResponseBody
    public Map Selectpipe(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        //查询资产的 a_attribute 有去重 有几种不重复的类型
        List<Assets> SelectAssetsshebie = statisticalMapper.SelectAssetsshebie();
        //查询出公司名
        List<Company> SelectCompery = statisticalMapper.SelectCompery();
        Map map2 = new HashMap<String, Object>();
        List<Pipe> SelectPipe = statisticalMapper.SelectPipe();
        List SelectPipe1=new ArrayList();
        for(int  a=0;a<SelectPipe.size();a++){
            SelectPipe1.add(SelectPipe.get(a).getPipe_time());
        }
        Date nowTime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String shijian = sdFormatter.format(nowTime);
        List he = new ArrayList();
        //循环SelectAssetsshebie里面的设备类型
        for (int a = 0; a < SelectCompery.size(); a++) {
            temporary temporary = new temporary();
            List he1 = new ArrayList();
            List he2 = new ArrayList();
            he.add(temporary);
            temporary.setPipe_pipe(he1);
            temporary.setShijian(he2);
            temporary.setC_name(SelectCompery.get(a).getC_name());
            //循环  SelectCompery的公司名
            for (int i = 0; i < SelectAssetsshebie.size(); i++) {
                //将公司名以及设备类型
                double zong = statisticalMapper.zong(SelectAssetsshebie.get(i).getA_attribute(), SelectCompery.get(a).getC_name());
                double zhengchang = statisticalMapper.zhengchang(SelectAssetsshebie.get(i).getA_attribute(), SelectCompery.get(a).getC_name());
                double wanhaolu = (zhengchang / zong) * 100;
                if (zong == 0.0) {
                    wanhaolu = 0;
                }
                DecimalFormat df = new DecimalFormat("0");
                String s = df.format(wanhaolu);
                he1.add(s);
                he2.add(SelectAssetsshebie.get(i).getA_attribute());
                if (SelectPipe.size() == 0) {
                    statisticalMapper.insertpipe(SelectCompery.get(a).getC_name(), SelectAssetsshebie.get(i).getA_attribute(), shijian, wanhaolu);
                }else{
                    int con=Collections.frequency(SelectPipe1,shijian);
                    if(con==0) {
                        statisticalMapper.insertpipe(SelectCompery.get(a).getC_name(), SelectAssetsshebie.get(i).getA_attribute(), shijian, wanhaolu);
                    }
                }
            }
        }
        map.put("Selectpipe", he);
        return map;
    }
    /**
     * 获取从当前时间往前的30天
     * @param response
     * @return
     */

    @RequestMapping("OnthepipeYesterday")
    @ResponseBody
    public Map OnthepipeYesterday(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        //查询出公司名
        List<Company> SelectCompery = statisticalMapper.SelectCompery();
        //定义一个List 集合
        List pipeyue=new ArrayList();
        //循环公司名一个一个输出
        for(int a =0;a<SelectCompery.size();a++){
            int ca=0;
            //定义两个List集合
            List pipeyue1=new ArrayList();
            List pipeyue2=new ArrayList();
            //定义一个对象
            temporary temporary = new temporary();
            //放入设备完好率
            temporary.setPipe_pipe(pipeyue1);
            //放入从今天往前推30天的时间
            temporary.setShijian(pipeyue2);
            temporary.setC_name(SelectCompery.get(a).getC_name());
            pipeyue.add(temporary);
            for(int c=1;c<=30;c++){
                Integer thirty=statisticalMapper.OnthepipeYesterday(SelectCompery.get(a).getC_name(),c);
                if(thirty==null){thirty=0; }
                DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
                ca=ca+(-24);
                Calendar calendar=Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,ca);
                String yesterdayDate=dateFormat.format(calendar.getTime());
                pipeyue2.add(yesterdayDate);
                pipeyue1.add(thirty);
            }
        }
        map.put("pipethirty",pipeyue);
        return map;
    }





    /**
     * 获取当月和上月对比
     * @param response
     * @return
     */
    @RequestMapping("Onthepipe")
    @ResponseBody
    public Map Onthepipe(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        //查询出公司
        List<Company> SelectCompery = statisticalMapper.SelectCompery();
        //循环公司名字查询出上个月和当月的设备完好率存入List 集合里
        List list=new ArrayList();
        for(int a =0;a<SelectCompery.size();a++){
            Month monthselect=new Month();
            Integer dangyue=statisticalMapper.Onthepipe(SelectCompery.get(a).getC_name());
            Integer xiayue= statisticalMapper.Onthepipe1(SelectCompery.get(a).getC_name());
            if(xiayue==null){
                xiayue=0;
            }
            //获取当前时间
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH )+1;
            String yearmonth=year+"-"+month;

            //获取上月时间
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.MONTH, -1);
            Date m = c.getTime();
            String mon = format.format(m);
            //将计算完的数据添加到自定义的bean类放到list集合里面返回到前台
            monthselect.setDangyue(dangyue);
            monthselect.setXiayue(xiayue);
            monthselect.setMon(mon);
            monthselect.setScompery(SelectCompery.get(a).getC_name());
            monthselect.setYearmonth(yearmonth);
            list.add(monthselect);
        }
        map.put("Onthepipe",list);
        return map;
    }

















}

