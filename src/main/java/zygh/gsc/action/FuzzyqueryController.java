package zygh.gsc.action;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-11-01 13:50
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zygh.gsc.dao.FuzzyqueryMapper;
import zygh.gsc.service.punctuationService;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/asset")
public class FuzzyqueryController {

    @Autowired
    private FuzzyqueryMapper FuzzyqueryMapper;

    /**
     * 模糊查询故障损坏设备 以及未派单的设备
     * @param a_ip
     * @param c_name
     * @param a_location
     * @param a_category
     * @param a_attribute
     * @param orders_orders_state
     * @param response
     * @return
     */

    @RequestMapping("/SelectOrdersfuzzyquery")
    @ResponseBody
    public Map<String, List<Object>> SelectOrdersfuzzyquery(String a_ip,String c_name,
                                                            String a_location ,String a_category, String  a_attribute,
                                                            String  orders_orders_state ,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        List SelectOrdersfuzzyquery=FuzzyqueryMapper.SelectOrdersfuzzyquery(a_ip,c_name,a_location,a_category,a_attribute,orders_orders_state);
        map.put("SelectOrdersfuzzyquery", SelectOrdersfuzzyquery);
        return map;
    }


    /**
     * 模糊查询以接单设备
     * @param repair_level
     * @param repair_processing
     * @param repair_head
     * @param repair_state
     * @param repair_data
     * @param repair_data1
     * @param response
     * @return
     */
    @RequestMapping("/SelectRepairOrdersfuzzyquery")
    @ResponseBody
    public Map SelectRepairOrdersfuzzyquery(int a,String repair_level,String repair_processing,
                                                            String repair_head ,String repair_state, String  repair_data,
                                                            String  repair_data1 ,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        List SelectRepairOrdersfuzzyquery=FuzzyqueryMapper.SelectRepairOrdersfuzzyquery(a,repair_level,repair_processing,repair_head,repair_state,repair_data,repair_data1);
        map.put("SelectRepairOrdersfuzzyquery", SelectRepairOrdersfuzzyquery);
        return map;
    }




}
