package zygh.gsc.action;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-08-15 10:37
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zygh.gsc.bean.Company;
import zygh.gsc.bean.Groupy;
import zygh.gsc.dao.CompanyMapper;
import zygh.gsc.dao.middlewareMapper;
import zygh.gsc.service.CompanyService;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/asset")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/Companyselect")
    @ResponseBody
    /**
     *  查询所有公司的信息
     *
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:19
     * @param [response]
     * @return java.util.Map<java.lang.String , java.util.List < java.lang.Object>>
     */
    public Map<String, List<Object>> Companyselect(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        List Companyselect = companyService.Companyselect();
        map.put("Companyselect", Companyselect);
        return map;
    }
    //添加资产数据

    /**
     * 新增加公司：把公司的名字以及电话以对象的形式接受然后保存到数据库中
     *
     * @param [company, model, response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:28
     */


    @RequestMapping("/insertCompany")
    @ResponseBody
    public ModelMap insertCompany(Company company, Model model, HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        int insertCompany = companyService.insertCompany(company);
        map.put("insertCompany", insertCompany);
        return map;
    }
    //删除资产数据

    /**
     * 删除公司：把公司的c_id从前台用angularjs 传到后台
     * 根据c_id删除这条数据
     *
     * @param [c_id, response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:28
     */


    @RequestMapping("/deleteCompany")
    @ResponseBody
    public ModelMap deleteCompany(Integer [] c_id, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        //删除公司表数据
        int deleteCompany = companyService.deleteCompany(c_id);
        map.put("deleteCompany", deleteCompany);
        return map;
    }

    //修改

    /**
     * 修改公司：将公司以Company对象的形式接收查询对象里ID 的这条数据进行修改
     *
     * @param [company, response]
     * @return org.springframework.ui.ModelMap
     * @author 研发部郭帅昌
     * @date 2018/8/17 14:30
     */

    @RequestMapping("/updateCompany")
    @ResponseBody
    public ModelMap updateCompany(Company company, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        int updateCompany = companyService.updateCompany(company);
        map.put("updateCompany", updateCompany);
        return map;
    }


    //小组
    @RequestMapping("/groupyselect")
    @ResponseBody
    public ModelMap groupy(Integer c_id,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        List groupyselect = companyService.groupyselect(c_id);
        map.put("groupyselect", groupyselect);
        return map;
    }

    //小组下的人
    @RequestMapping("/Groupmembersselect")
    @ResponseBody
    public ModelMap Groupmembers(Integer group_id,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelMap map = new ModelMap();
        List Groupmembersselect = companyService.Groupmembersselect(group_id);
        map.put("Groupmembersselect", Groupmembersselect);
        return map;
    }


    //小组
    @RequestMapping("/Relationselect")
    @ResponseBody
    public Map<String, List<Object>> Relationselect(String a_location, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        List Companyselect = companyService.Relationselect(a_location);
        map.put("Companyselect", Companyselect);
        return map;
    }

}
