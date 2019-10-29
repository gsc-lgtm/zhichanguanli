package zygh.gsc.service;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-10-15 15:52
 */

import zygh.gsc.bean.BrokenInfo;

import java.util.List;

public interface BrokanInfoService {

    public List<BrokenInfo> aa();
    public List<BrokenInfo> selectAllBrokenInfo();

    public void updateBrokenInfo(Integer broken_id);
}
