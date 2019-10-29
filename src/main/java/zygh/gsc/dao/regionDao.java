package zygh.gsc.dao;
/*

      标记
            公司：中裕广恒科技股份有限公司
            项目：资产管理系统
            编程人员：研发部郭帅昌
            时间：2018-8-10

*
* */

import org.springframework.stereotype.Repository;

import zygh.gsc.bean.Region;

import java.util.List;
import java.util.Map;

@Repository
public interface regionDao {
    /**
     * 查询所有区域
     *
     * @param []
     * @return java.util.List<zygh.gsc.bean.Region>
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:08
     */

    public List<Region> chaxunRegion();

    /**
     * 添加区域
     *
     * @param [region]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:09
     */

    public int regioninsert(Region region);

    /**
     * 删除区域
     *
     * @param [r_id]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:09
     */

    public int regiondelete(Integer [] r_id);

    /**
     * 区域修改
     *
     * @param [region]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:09
     */

    public int regionupdate(Region region);
}
