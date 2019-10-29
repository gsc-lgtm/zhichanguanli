package zygh.gsc.service.impl;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-08-24 14:30
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zygh.gsc.bean.Region;
import zygh.gsc.dao.regionDao;
import zygh.gsc.service.RegionService;

import java.util.List;

@Service("regionService")
public class RegionServiceimpl implements RegionService {
    @Autowired
    private regionDao regiondao;
    /**
     * 查询所有区域
     *
     * @param []
     * @return java.util.List<zygh.gsc.bean.Region>
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:08
     */
    public List<Region> chaxunRegion() {
        return regiondao.chaxunRegion();
    }
    /**
     * 添加区域
     *
     * @param [region]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:09
     */
    public int regioninsert(Region region) {
        return regiondao.regioninsert(region);
    }
    /**
     * 删除区域
     *
     * @param [r_id]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:09
     */
    public int regiondelete(Integer [] r_id) {
        return regiondao.regiondelete(r_id);
    }
    /**
     * 区域修改
     *
     * @param [region]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:09
     */
    public int regionupdate(Region region) {
        return regiondao.regionupdate(region);
    }
}
