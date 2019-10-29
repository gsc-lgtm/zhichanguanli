package zygh.gsc.bean;

/*<!--         标记
            公司：中裕广恒科技股份有限公司
            项目：资产管理系统
            编程人员：研发部郭帅昌
            时间：2018-8-10
        -->*/
public class Region {

    private int r_id;//区域id (自增)
    private String r_name;//区域名称（金水区，高新区）


    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }


    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    @Override
    public String toString() {
        return "Region{" +
                "r_id=" + r_id +
                ", r_name='" + r_name + '\'' +
                '}';
    }
}
