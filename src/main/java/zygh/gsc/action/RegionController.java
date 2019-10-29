package zygh.gsc.action;
/*<!--         标记
            公司：中裕广恒科技股份有限公司
            项目：资产管理系统
            编程人员：研发部郭帅昌
            时间：2018-8-10
        -->*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zygh.gsc.bean.Region;
import zygh.gsc.service.RegionService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/asset")
public class RegionController {


    @Autowired
    private RegionService RegionService;

    /**
     * 查询区域的所有信息
     *
     * @param [response]
     * @return java.util.Map<java.lang.String   ,   java.util.List   <   zygh.gsc.bean.Region>>
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:54
     */

    @RequestMapping("/regionselect")
    @ResponseBody
    public Map<String, List<Region>> regionselect(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map<String, List<Region>> map = new HashMap<String, List<Region>>();
        List<Region> RegionList = RegionService.chaxunRegion();
        map.put("RegionList", RegionList);
        return map;
    }

    /**
     * 根据region对象进行添加
     *
     * @param [region, model, response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:56
     */

    @RequestMapping("/regioninsert")
    @ResponseBody
    public ModelMap insertzichan(Region region, Model model, HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        int regioninsert = RegionService.regioninsert(region);
        map.put("regioninsert", regioninsert);
        return map;
    }

    /**
     * 根据r_id删除相应id的数据
     *
     * @param [r_id, response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:57
     */

    @RequestMapping("/regiondelete")
    @ResponseBody
    public ModelMap deletezichan(Integer [] r_id, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        int regiondelete = RegionService.regiondelete(r_id);
        map.put("regiondelete", regiondelete);
        return map;
    }

    /**
     * 根据region对象进行修改
     *
     * @param [region, response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:57
     */

    @RequestMapping("/regionupdate")
    @ResponseBody
    public ModelMap updatezichan(Region region, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        int regionupdate = RegionService.regionupdate(region);
        map.put("regionupdate", regionupdate);
        return map;
    }
}
