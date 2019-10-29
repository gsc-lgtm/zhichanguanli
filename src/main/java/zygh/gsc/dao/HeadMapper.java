package zygh.gsc.dao;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-10-22 11:46
 */

import zygh.gsc.bean.Head;
import zygh.gsc.bean.User;

import java.util.List;

public interface HeadMapper {
   /* public List<Head> Headselect();*/
   public List<Head> Headselect();
    public User Headselect123();
    public List<Head> Headselect2(int head_id);

    public  int Headinsert(Head head);

    public  int Headselectdelete(Integer  head_id);
    public  int Headupdate(Head head);

    public List<Head> Headselectxunhuan(int head_id);
}
