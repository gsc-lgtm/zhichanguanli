package zygh.gsc.action;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-09-05 09:21
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zygh.gsc.bean.Header;
import zygh.gsc.service.CompanyService;
import zygh.gsc.service.HeaderService;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/asset")
public class HeaderController {

    @Autowired
    private HeaderService headerService;

    @RequestMapping("/Headerselect")
    @ResponseBody
    public ModelMap Headerselect(int hea_Indexes, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        List<Header> Headerselect = headerService.Headerselect(hea_Indexes);
        map.put("Headerselect", Headerselect);
        return map;
    }



}
