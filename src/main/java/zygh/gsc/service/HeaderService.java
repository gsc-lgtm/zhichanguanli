package zygh.gsc.service;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-09-05 09:26
 */

import zygh.gsc.bean.Header;

import java.util.List;

public interface HeaderService {
    public List<Header> Headerselect(int hea_Indexes);
}
