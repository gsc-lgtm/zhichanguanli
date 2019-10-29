package zygh.gsc.bean;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-10-22 11:40
 */

import java.util.List;

public class Head {
    private  int head_id;
    private  int head_taitou_id;
    private String head_name;
    private String head_style;
    private String head_headid;
    private List<Head> HeadList;

    public String getHead_headid() {
        return head_headid;
    }

    public void setHead_headid(String head_headid) {
        this.head_headid = head_headid;
    }

    public List<Head> getHeadList() {
        return HeadList;
    }

    public void setHeadList(List<Head> headList) {
        HeadList = headList;
    }

    public int getHead_id() {
        return head_id;
    }

    public void setHead_id(int head_id) {
        this.head_id = head_id;
    }

    public int getHead_taitou_id() {
        return head_taitou_id;
    }

    public void setHead_taitou_id(int head_taitou_id) {
        this.head_taitou_id = head_taitou_id;
    }

    public String getHead_name() {
        return head_name;
    }

    public void setHead_name(String head_name) {
        this.head_name = head_name;
    }

    public String getHead_style() {
        return head_style;
    }

    public void setHead_style(String head_style) {
        this.head_style = head_style;
    }

    @Override
    public String toString() {
        return "Head{" +
                "head_id=" + head_id +
                ", head_taitou_id=" + head_taitou_id +
                ", head_name='" + head_name + '\'' +
                ", head_style='" + head_style + '\'' +
                ", head_headid='" + head_headid + '\'' +
                ", HeadList=" + HeadList +
                '}';
    }
}
