package zygh.gsc.service.impl;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-10-15 15:57
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zygh.gsc.bean.BrokenInfo;
import zygh.gsc.dao.BolgMapper;
import zygh.gsc.dao.BrokenInfoMapper;
import zygh.gsc.service.BrokanInfoService;

import java.util.List;
@Service("BrokanInfoService")
public class BrokanInfoServiceimpl implements BrokanInfoService {
    @Autowired
    private BrokenInfoMapper BrokenInfoMapper;
    public List<BrokenInfo> aa() {
        return BrokenInfoMapper.aa();
    }

    public List<BrokenInfo> selectAllBrokenInfo() {
        return BrokenInfoMapper.selectAllBrokenInfo();
    }

    public void updateBrokenInfo(Integer broken_id) {
         BrokenInfoMapper.updateBrokenInfo(broken_id);
    }
}
