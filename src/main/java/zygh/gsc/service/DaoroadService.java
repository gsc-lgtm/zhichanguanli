package zygh.gsc.service;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-08-24 14:27
 */

import org.springframework.stereotype.Repository;
import zygh.gsc.bean.Daoroad;
import zygh.gsc.bean.Region;
import zygh.gsc.bean.Trunkroad;

import java.util.List;
import java.util.Map;
@Repository
public interface DaoroadService {
    /**
     * 查询出所有道路
     *
     * @param []
     * @return java.util.List<java.util.Map   <   java.lang.String   ,   java.lang.Object>>
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:02
     */

    public List<Map<String, Object>> Daoroadselect();

    /**
     * 根据所有道路关联相应得区域
     *
     * @param []
     * @return java.util.List<zygh.gsc.bean.Region>
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:02
     */

    public List<Region> Regionselect();


    public List<Trunkroad> Trunkroadselect();
    /**
     * 添加道路
     *
     * @param [daoroad]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:03
     */

    public int Daoroadinsert(Daoroad daoroad);

    /**
     * 删除道路
     *
     * @param [d_uid]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:03
     */

    public int Daoroaddelete(Integer [] d_uid);

    /**
     * 修改道路
     *
     * @param [daoroad]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:03
     */

    public int Daoroadupdate(Daoroad daoroad);

}
