package zygh.gsc.service.impl;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-08-24 14:30
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zygh.gsc.bean.Company;
import zygh.gsc.bean.Region;
import zygh.gsc.bean.middleware;
import zygh.gsc.dao.middlewareMapper;
import zygh.gsc.service.middlewareService;

import java.util.List;
@Service("middlewareService")
public class middlewareServiceimpl implements middlewareService {

    @Autowired
    private middlewareMapper middlewareMapper;

    public List<Company> Middlewareselect() {
        return middlewareMapper.Middlewareselect();
    }

    public List<middleware> quyuselect(int c_id) {
        return middlewareMapper.quyuselect(c_id);
    }

    public List<Region> Regionselect() {
        return middlewareMapper.Regionselect();
    }

    public List<Company> Companyselect() {
        return middlewareMapper.Companyselect();
    }

    public int insertmiddleware(middleware middleware) {
        return middlewareMapper.insertmiddleware(middleware);
    }

    public int deletemiddleware(Integer [] c_id) {
        return middlewareMapper.deletemiddleware(c_id);
    }

    public int deleteupdate(int c_id) {
        return middlewareMapper.deleteupdate(c_id);
    }

    public int updatemiddleware(middleware middleware) {
        return middlewareMapper.updatemiddleware(middleware);
    }
}
