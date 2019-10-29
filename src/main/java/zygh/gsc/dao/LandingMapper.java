package zygh.gsc.dao;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-12-01 15:50
 */

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import zygh.gsc.bean.Company;
import zygh.gsc.bean.User;

import java.util.List;
import java.util.Map;

@Repository
public interface LandingMapper {
    public  User LandingSelect(User user);

    public Company LandingSelectCompany(@Param("name") String name);


}
