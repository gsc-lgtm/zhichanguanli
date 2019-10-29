package zygh.gsc.bean;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-09-05 09:21
 */

public class Header {
    private int hea_id;
    private String hea_name;//表头
    private int hea_Indexes;//表类

    public int getHea_id() {
        return hea_id;
    }

    public void setHea_id(int hea_id) {
        this.hea_id = hea_id;
    }

    public String getHea_name() {
        return hea_name;
    }

    public void setHea_name(String hea_name) {
        this.hea_name = hea_name;
    }

    public int getHea_Indexes() {
        return hea_Indexes;
    }

    public void setHea_Indexes(int hea_Indexes) {
        this.hea_Indexes = hea_Indexes;
    }
}
