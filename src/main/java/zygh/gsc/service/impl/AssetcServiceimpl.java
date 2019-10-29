package zygh.gsc.service.impl;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-08-24 14:29
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zygh.gsc.bean.Assets;
import zygh.gsc.bean.Region;
import zygh.gsc.dao.BolgMapper;
import zygh.gsc.service.AssetsService;

import java.util.List;
import java.util.Map;

@Service("AssetsService")
public class AssetcServiceimpl implements AssetsService {
    @Autowired
    private BolgMapper bolgMapper;

    public List<Map<String, Object>> chaxun() {
        return bolgMapper.chaxun();
    }

    public List<Region> Regionselect() {
        return bolgMapper.Regionselect();
    }

    public List<Map<String, Object>> chaxunlink(String name,int a) {
        return bolgMapper.chaxunlink(name,a);
    }

    public List<Assets> selectdata(String name, String name1) {
        return bolgMapper.selectdata(name,name1);
    }

    public int insertzichan(Assets assets) {
        return bolgMapper.insertzichan(assets);
    }

    public int deletezichan(Integer [] a_id) {
        return  bolgMapper.deletezichan(a_id);
    }

    public int updatezichan(Assets assets) {
        return bolgMapper.updatezichan(assets);
    }

    public List<Map<String, Object>> daoluselect(int r_id) {
        return bolgMapper.daoluselect(r_id);
    }


}
