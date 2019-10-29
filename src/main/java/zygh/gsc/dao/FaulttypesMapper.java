package zygh.gsc.dao;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-11-01 15:10
 */

import zygh.gsc.bean.Faulttypes;

import java.util.List;

public interface FaulttypesMapper {
    /*常用语查询*/
    public List<Faulttypes> selectFaulttypes(int faulttypes_edno);
}
