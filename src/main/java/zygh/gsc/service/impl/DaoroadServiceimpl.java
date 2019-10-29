package zygh.gsc.service.impl;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-08-24 14:29
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zygh.gsc.bean.Daoroad;
import zygh.gsc.bean.Region;
import zygh.gsc.bean.Trunkroad;
import zygh.gsc.dao.DaoroadMapper;
import zygh.gsc.service.DaoroadService;

import java.util.List;
import java.util.Map;

@Service("DaoroadService")
public class DaoroadServiceimpl implements DaoroadService {

    @Autowired
    private DaoroadMapper daoroadmapper;
    public List<Map<String, Object>> Daoroadselect() {
        return daoroadmapper.Daoroadselect();
    }

    public List<Region> Regionselect() {
        return daoroadmapper.Regionselect();
    }

    public List<Trunkroad> Trunkroadselect() {
        return daoroadmapper.Trunkroadselect();
    }

    public int Daoroadinsert(Daoroad daoroad) {
        return daoroadmapper.Daoroadinsert(daoroad);
    }

    public int Daoroaddelete(Integer [] d_uid) {
        return daoroadmapper.Daoroaddelete(d_uid);
    }

    public int Daoroadupdate(Daoroad daoroad) {
        return daoroadmapper.Daoroadupdate(daoroad);
    }
}
