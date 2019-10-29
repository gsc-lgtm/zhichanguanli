package zygh.gsc.action;
    /*     标记
            公司：中裕广恒科技股份有限公司
            项目：资产管理系统
            编程人员：研发部郭帅昌
            时间：2018-8-6
        */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zygh.gsc.bean.Assets;
import org.springframework.ui.Model;
import zygh.gsc.bean.Region;
import zygh.gsc.dao.BolgMapper;
import zygh.gsc.dao.middlewareMapper;
import zygh.gsc.service.AssetsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping("/asset")
public class AssetsController {

   /* @Autowired
    private BolgMapper bolgMapper;*/
    @Autowired
    private AssetsService AssetsService;

    /**
     * 查询资产的所有信息
     *
     * @param [response]
     * @return java.util.Map<java.lang.String   ,   java.util.List   <   java.lang.Object>>
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:37
     */

    @RequestMapping("/select")
    @ResponseBody
    public Map<String, List<Object>> select(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        List userList = AssetsService.chaxun();
        map.put("data", userList);
        return map;
    }

    /**
     * 迷糊查询 根据把name 字段接收进行模糊查询
     *
     * @param [name, response]
     * @return java.util.Map<java.lang.String   ,   java.util.List   <   zygh.gsc.bean.Assets>>
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:38
     */

    //模糊查询所有想要的字段
    @RequestMapping("/selectlimt")
    @ResponseBody
    public Map<String, List<Object>> selectlimt(String name,int a, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map<String, List<Object>> map = new HashMap<String, List<Object>>();
        List selectlimt = AssetsService.chaxunlink(name,a);
        map.put("selectlimt", selectlimt);
        return map;
    }

    /**
     * 根据接收name,name1字符串进行判断查询出时间段之间的数据
     *
     * @param [name, name1, response]
     * @return java.util.Map<java.lang.String   ,   java.util.List   <   zygh.gsc.bean.Assets>>
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:40
     */

    @RequestMapping("/selectdata")
    @ResponseBody
    public Map<String, List<Assets>> selectdata(String name, String name1, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map<String, List<Assets>> map = new HashMap<String, List<Assets>>();
        List<Assets> selectdata = AssetsService.selectdata(name, name1);
        map.put("selectdata", selectdata);
        return map;
    }

    /**
     * 根据assets对象进行添加
     *
     * @param [assets, model, response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:44
     */

    @RequestMapping("/insertzichan")
    @ResponseBody
    public ModelMap insertzichan(Assets assets, Model model, HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        int insert = AssetsService.insertzichan(assets);
        map.put("insert", insert);
        return map;
    }

    /**
     * 根据a_id删除相应id的数据
     *
     * @param [a_id, response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:45
     */

    @RequestMapping("/deletezichan")
    @ResponseBody
    public ModelMap deletezichan(Integer [] a_id  , HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        int delete = AssetsService.deletezichan(a_id);
        map.put("delete", delete);
        return map;
    }

    /**
     * 根据assets对象进行修改
     *
     * @param [assets, response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:45
     */

    @RequestMapping("/updatezichan")
    @ResponseBody
    public ModelMap updatezichan(Assets assets, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        int update = AssetsService.updatezichan(assets);
        map.put("update", update);
        return map;
    }

    /**
     * 联动根据道路关联区域把区域ID（ps:r_id）获取到 然后查找相对应得道路
     *
     * @param [r_id, response]
     * @return java.util.Map<java.lang.String   ,   java.util.List   <   java.lang.Object>>
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:46
     */

    @RequestMapping("/daoluselect")
    @ResponseBody
    public Map<String, List<Object>> daoluselect(int r_id, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        List daoluselect = AssetsService.daoluselect(r_id);
        map.put("daoluselect", daoluselect);
        return map;
    }

    /**
     * 查询区域信息方便跟道路进行联动
     *
     * @param [response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:47
     */

    @RequestMapping("/RegionAssets")
    @ResponseBody
    public ModelMap Regionselect(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        List<Region> Regionselect = AssetsService.Regionselect();
        map.put("Regionselect", Regionselect);
        return map;
    }







}
