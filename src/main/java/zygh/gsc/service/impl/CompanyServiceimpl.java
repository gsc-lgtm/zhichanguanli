package zygh.gsc.service.impl;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-08-24 14:29
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zygh.gsc.bean.Company;
import zygh.gsc.bean.Groupmembers;
import zygh.gsc.bean.Groupy;
import zygh.gsc.dao.CompanyMapper;
import zygh.gsc.service.CompanyService;

import java.util.List;
import java.util.Map;

@Service("CompanyService")
public class CompanyServiceimpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    public List<Map<String, Object>> Companyselect() {
        return companyMapper.Companyselect();
    }

    public int insertCompany(Company company) {
        return companyMapper.insertCompany(company);
    }

    public int deleteCompany(Integer [] c_id) {
        return companyMapper.deleteCompany(c_id);
    }

    public int updateCompany(Company company) {
        return companyMapper.updateCompany(company);
    }

    public List<Groupy> groupyselect(Integer c_id) {
        return companyMapper.groupyselect(c_id);
    }

    public List<Groupmembers> Groupmembersselect(Integer group_id) {
        return companyMapper.Groupmembersselect(group_id);
    }

    public List<Map<String, Object>> Relationselect(String a_location) {
        return companyMapper.Relationselect(a_location);
    }
}
