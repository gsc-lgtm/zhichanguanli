package zygh.gsc.action;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-11-01 15:09
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zygh.gsc.dao.FaulttypesMapper;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/asset")
public class FaulttypesController {

    @Autowired
    private FaulttypesMapper faulttypesMapper;

    /**
     * 常用语查询
     * @param response
     * @return
     */
    @RequestMapping("/selectFaulttypes")
    @ResponseBody
    public Map selectFaulttypes(int faulttypes_edno, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        List selectFaulttypes =faulttypesMapper.selectFaulttypes(faulttypes_edno);
        map.put("selectFaulttypes",selectFaulttypes);
        return map;
    }


}
