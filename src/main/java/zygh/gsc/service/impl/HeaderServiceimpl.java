package zygh.gsc.service.impl;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-09-05 09:26
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zygh.gsc.bean.Header;
import zygh.gsc.dao.BolgMapper;
import zygh.gsc.dao.HeaderMapper;
import zygh.gsc.service.HeaderService;

import java.util.List;

@Service("HeaderService")
public class HeaderServiceimpl implements HeaderService {
    @Autowired
    private HeaderMapper headerMapper;
    public List<Header> Headerselect(int hea_Indexes) {
        return headerMapper.Headerselect(hea_Indexes);
    }
}
