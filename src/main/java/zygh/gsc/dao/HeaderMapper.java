package zygh.gsc.dao;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-09-05 09:26
 */

import zygh.gsc.bean.Header;
import zygh.gsc.bean.Region;

import java.util.List;

public interface HeaderMapper {
    public List<Header> Headerselect(int hea_Indexes);
}
