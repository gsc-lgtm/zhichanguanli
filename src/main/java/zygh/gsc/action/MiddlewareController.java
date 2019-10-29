package zygh.gsc.action;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-08-14 08:54
 */

import com.google.gson.GsonBuilder;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zygh.gsc.bean.*;
import zygh.gsc.dao.BolgMapper;
import zygh.gsc.dao.middlewareMapper;
import zygh.gsc.service.middlewareService;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/asset")
public class MiddlewareController {

    @Autowired
    private middlewareService middlewareService;
    //查询数据

    /**
     * 查询出公司管理得区域
     *
     * @param [response]
     * @return void
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:59
     */

    @RequestMapping(value = "Middlewareselect", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String Middlewareselect(HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=utf-8");
        ModelMap mapQQ = new ModelMap();
        JSONObject jsonObject = new JSONObject();
        List<Company> Companyselect = middlewareService.Middlewareselect();
        List<Object> AA = new ArrayList<Object>();
        for (Company company : Companyselect) {
            ModelMap map = new ModelMap();
            ResultVo resultVo = new ResultVo();
            List<middleware> middlewareList = middlewareService.quyuselect(company.getC_id());
            resultVo.setC_id(company.getC_id());
            resultVo.setC_name(company.getC_name());
            resultVo.setC_phone(company.getC_phone());
            resultVo.setM_id(middlewareList.get(0).getM_id());
            resultVo.setRegionList(middlewareList);
            map.put("aaa", AA);
            AA.add(resultVo);
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.disableHtmlEscaping();
        String data = gsonBuilder.create().toJson(AA);
        return data;
            /*JSONArray array = JSONArray.fromObject(AA);
            response.getWriter().print(array);*/
    }

    /**
     * 查询公司，方便区域跟公司联动
     *
     * @param [response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 15:05
     */

    @RequestMapping("/RegionMiddleware")
    @ResponseBody
    public ModelMap Regionselect(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        List<Region> Regionselect = middlewareService.Regionselect();
        map.put("Regionselect", Regionselect);
        return map;
    }

    /**
     * 查询区域，方便公司跟区域联动
     *
     * @param [response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 15:05
     */

    @RequestMapping("/CompanyMiddleware")
    @ResponseBody
    public ModelMap Companyselect(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        List<Company> Companyselect = middlewareService.Companyselect();
        map.put("Companyselect", Companyselect);
        return map;
    }

    /**
     * 添加公司管理的区域，根据c_id(ps：公司id)R_id（ps:区域id）
     * 在中间表中进行添加管理
     *
     * @param [c_id, r_id, model, response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 15:00
     */

    @RequestMapping("/insertmiddleware")
    @ResponseBody
    public ModelMap insertzichan(int c_id, Integer[] r_id, Model model, HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        for (int i = 0; i < r_id.length; i++) {
            if (r_id[i] != null && r_id[i] != 0) {
                middleware middleware = new middleware();
                Region Region = new Region();
                Region.setR_id(r_id[i]);
                middleware.setC_id(c_id);
                middleware.setR_id(Region.getR_id());
                int a = middlewareService.insertmiddleware(middleware);
                map.put("insertmiddleware", a);
            }
        }
        return map;
    }

    /**
     * 根据c_id（ps:公司id）删除这个公司管理的区域
     *
     * @param [c_id, response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 15:02
     */

    @RequestMapping("/deletemiddleware")
    @ResponseBody
    public ModelMap deletemiddleware(Integer [] c_id, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        int deletemiddleware = middlewareService.deletemiddleware(c_id);
        map.put("deletemiddleware", deletemiddleware);
        return map;
    }


    //修改公司所管理的区域

    /**
     * 修改公司管理的区域，根据c_id(ps：公司id)R_id（ps:区域id）清空所有这个公司管理的区域
     * 在从新添加这个管理的区域 实现修改
     *
     * @param [c_id, r_id, response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 15:03
     */

    @RequestMapping("/updatemiddleware")
    @ResponseBody
    public ModelMap updatezichan(int c_id, Integer[] r_id, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        middlewareService.deleteupdate(c_id);
        for (int i = 0; i < r_id.length; i++) {
            if (r_id[i] != null && r_id[i] != 0) {
                middleware middleware = new middleware();
                Region Region = new Region();
                Region.setR_id(r_id[i]);
                middleware.setC_id(c_id);
                middleware.setR_id(Region.getR_id());
                int a = middlewareService.updatemiddleware(middleware);
                map.put("updatemiddleware", a);
            }
        }
        return map;
    }


}
