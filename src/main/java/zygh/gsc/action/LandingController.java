package zygh.gsc.action;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-12-01 15:46
 */

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zygh.gsc.bean.Company;
import zygh.gsc.bean.User;
import zygh.gsc.dao.LandingMapper;

import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/asset")
public class LandingController {
    @Autowired
    private LandingMapper landingMapper;


    @RequestMapping("/Landing")
    @ResponseBody
    public ModelMap Landing(User user, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        User landing = landingMapper.LandingSelect(user);
        ModelMap map = new ModelMap();
        if (landing != null) {
           Company landing1=landingMapper.LandingSelectCompany(landing.getUser_cardholder());
           map.put("landing", landing.getUser_id()+","+landing.getUser_cardholder()+","+landing.getUser_level()+","+landing1.getC_name());
        } else {
            map.put("landing", 0);
        }
        return map;
    }



}
