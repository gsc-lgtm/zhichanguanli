package zygh.gsc.dao;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-08-14 08:55
 */


import org.springframework.stereotype.Repository;
import zygh.gsc.bean.Assets;
import zygh.gsc.bean.Company;
import zygh.gsc.bean.Region;
import zygh.gsc.bean.middleware;


import java.util.List;
import java.util.Map;

@Repository
public interface middlewareMapper {
    /**
     * 查询出所有公司，方便字符串拼接
     *
     * @param []
     * @return java.util.List<zygh.gsc.bean.Company>
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:04
     */

    public List<Company> Middlewareselect();

    /**
     * 根据查询出来公司ID查询中间表相对应管辖得区域
     *
     * @param [c_id]
     * @return java.util.List<zygh.gsc.bean.middleware>
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:04
     */

    public List<middleware> quyuselect(int c_id);

    /**
     * 查询区域方便联动
     *
     * @param []
     * @return java.util.List<zygh.gsc.bean.Region>
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:05
     */

    public List<Region> Regionselect();

    /**
     * 查询公司方便联动
     *
     * @param []
     * @return java.util.List<zygh.gsc.bean.Region>
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:05
     */

    public List<Company> Companyselect();

    /**
     * 给公司分配管辖区域
     *
     * @param [middleware]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:06
     */

    public int insertmiddleware(middleware middleware);

    /**
     * 删除这个公司管辖得所有区域
     *
     * @param [c_id]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:07
     */

    public int deletemiddleware(Integer [] c_id);

    /**
     * 修改这个公司管辖得区域
     *
     * @param [c_id]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:07
     */

    public int deleteupdate(int c_id);

    public int updatemiddleware(middleware middleware);


}
