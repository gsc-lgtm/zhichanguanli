package zygh.gsc.dao;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-11-07 17:04
 */

import org.apache.ibatis.annotations.Param;
import zygh.gsc.bean.Assets;
import zygh.gsc.bean.Company;
import zygh.gsc.bean.Pipe;

import java.util.List;
import java.util.Map;

public interface StatisticalMapper {

    public List<Map<Object, String>> SelectStatistical(@Param("name") String name);

    public List<Assets> SelectAssetsshebie();

    public List<Company> SelectCompery();

    public int zong(@Param("name") String name, @Param("compary") String compary);

    public int zhengchang(@Param("name") String name, @Param("compary") String compary);

    public int insertpipe(@Param("pipe_name") String pipe_name, @Param("pipe_category") String pipe_category, @Param("pipe_time") String pipe_time, @Param("pipe_pipe") double pipe_pipe);

    public List<Pipe> SelectPipe();

    public int updatepipe(@Param("pipe_id") int pipe_id, @Param("pipe_time") String pipe_time, @Param("pipe_pipe") double pipe_pipe);


    /**
     * 获取上月和当月的设备完好率
     *
     * @param comparyname
     * @return
     */
    //当月
    public Integer Onthepipe(@Param("comparyname") String comparyname);

    //下月
    public Integer Onthepipe1(@Param("comparyname") String comparyname);

    /**
     * 获取当前时间往前推30天
     *
     * @param comparyname
     * @param day
     * @return
     */
    public Integer OnthepipeYesterday(@Param("comparyname") String comparyname, @Param("day") int day);
}
