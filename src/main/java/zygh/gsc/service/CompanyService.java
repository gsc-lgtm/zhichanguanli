package zygh.gsc.service;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-08-24 14:26
 */

import org.springframework.stereotype.Repository;
import zygh.gsc.bean.Company;
import zygh.gsc.bean.Groupmembers;
import zygh.gsc.bean.Groupy;

import java.util.List;
import java.util.Map;
@Repository
public interface CompanyService {
    /**
     * 查询所有公司
     *
     * @param []
     * @return java.util.List<java.util.Map   <   java.lang.String   ,   java.lang.Object>>
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:01
     */

    public List<Map<String, Object>> Companyselect();

    /**
     * 添加公司
     *
     * @param [company]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:01
     */

    public int insertCompany(Company company);

    /**
     * 删除公司
     *
     * @param [c_id]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:01
     */

    public int deleteCompany(Integer [] c_id);

    /**
     * 对公司进行修改
     *
     * @param [company]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:02
     */

    public int updateCompany(Company company);

    //小组
    public List<Groupy> groupyselect(Integer c_id);
    //小组下的人
    public List<Groupmembers> Groupmembersselect(Integer group_id);
    //所有关联
    public List<Map<String, Object>> Relationselect(String a_location);
}
