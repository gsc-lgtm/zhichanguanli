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
import zygh.gsc.bean.Daoroad;
import zygh.gsc.bean.Region;
import zygh.gsc.bean.Trunkroad;
import zygh.gsc.dao.DaoroadMapper;
import zygh.gsc.dao.middlewareMapper;
import zygh.gsc.dao.regionDao;
import zygh.gsc.service.DaoroadService;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
    @RequestMapping("/asset")
public class DaoroadController {


    @Autowired
    private DaoroadService daoroadService;

    /**
     * 查询道路的所有信息
     *
     * @param [response]
     * @return java.util.Map<java.lang.String   ,   java.util.List   <   java.lang.Object>>
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:51
     */
    @RequestMapping("/Daoroadselect")
    @ResponseBody
    public Map<String, List<Object>> regionselect(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        List Daoroadselect = daoroadService.Daoroadselect();
        map.put("Daoroadselect", Daoroadselect);
        return map;
    }

    /**
     * 查询区域信息方便跟道路进行联动
     *
     * @param [response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:52
     */
    @RequestMapping("/RegionDaoroad")
    @ResponseBody
    public ModelMap Regionselect(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        List<Region> Regionselect = daoroadService.Regionselect();
        map.put("Regionselect", Regionselect);
        return map;
    }


    @RequestMapping("/Trunkroadselect")
    @ResponseBody
    public ModelMap Trunkroadselect(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        List<Trunkroad> Trunkroadselect = daoroadService.Trunkroadselect();
        map.put("Trunkroadselect", Trunkroadselect);
        return map;
    }

    /**
     * 根据daoroad对象进行道路添加
     *
     * @param [daoroad, model, response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:53
     */
    @RequestMapping("/Daoroadinsert")
    @ResponseBody
    public ModelMap insertzichan(Daoroad daoroad, Model model, HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        int Daoroadinsert = daoroadService.Daoroadinsert(daoroad);
        map.put("Daoroadinsert", Daoroadinsert);
        return map;
    }

    //删除道路数据

    /**
     * 根据d_uid删除相应id的数据
     *
     * @param [d_uid, response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:54
     */

    @RequestMapping("/Daoroaddelete")
    @ResponseBody
    public ModelMap deletezichan(Integer [] d_uid, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        int Daoroaddelete = daoroadService.Daoroaddelete(d_uid);
        map.put("Daoroaddelete", Daoroaddelete);
        return map;
    }

    //修改道路

    /**
     * 根据daoroad对象进行修改
     *
     * @param [daoroad, response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:54
     */

    @RequestMapping("/Daoroadupdate")
    @ResponseBody
    public ModelMap updatezichan(Daoroad daoroad, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        int Daoroadupdate = daoroadService.Daoroadupdate(daoroad);
        map.put("Daoroadupdate", Daoroadupdate);
        return map;
    }
}
