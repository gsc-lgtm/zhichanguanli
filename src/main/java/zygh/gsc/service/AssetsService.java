package zygh.gsc.service;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-08-24 14:28
 */

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import zygh.gsc.bean.Assets;
import zygh.gsc.bean.Region;

import java.util.List;
import java.util.Map;
@Component
public interface AssetsService {
    /**
     * 查询资产所在得道路以及道路所在得区域
     *
     * @param []
     * @return java.util.List<java.util.Map   <   java.lang.String   ,   java.lang.Object>>
     * @author 研发部郭帅昌
     * @date 2018/8/21 15:25
     */

    public List<Map<String, Object>> chaxun();

    /**
     * 查询区域数据
     *
     * @param []
     * @return java.util.List<zygh.gsc.bean.Region>
     * @author 研发部郭帅昌
     * @date 2018/8/21 16:55
     */

    public List<Region> Regionselect();


    /**
     * 根据传过来得值进行模糊查詢
     *
     * @param [name]
     * @return java.util.List<java.util.Map   <   java.lang.String   ,   java.lang.Object>>
     * @author 研发部郭帅昌
     * @date 2018/8/21 16:56
     */

    public List<Map<String, Object>> chaxunlink(String name,int a);

    /**
     * 按照时间段查询
     *
     * @param [name, name1]
     * @return java.util.List<zygh.gsc.bean.Assets>
     * @author 研发部郭帅昌
     * @date 2018/8/21 16:56
     */

    public List<Assets> selectdata(@Param("name") String name, @Param("name1") String name1);

    /**
     * 录入新增资产
     *
     * @param [assets]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 16:56
     */

    public int insertzichan(Assets assets);

    /**
     * 根据id删除资产
     *
     * @param [a_id]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 16:57
     */

    public int deletezichan(Integer [] a_id);

    /**
     * 修改资产
     *
     * @param [assets]
     * @return int
     * @author 研发部郭帅昌
     * @date 2018/8/21 16:58
     */

    public int updatezichan(Assets assets);

    /**
     * 查询出道路属性方便联动
     *
     * @param [r_id]
     * @return java.util.List<java.util.Map   <   java.lang.String   ,   java.lang.Object>>
     * @author 研发部郭帅昌
     * @date 2018/8/21 16:59
     */

    public List<Map<String, Object>> daoluselect(int r_id);


}
