package zygh.gsc.bean;

import java.util.List;

/*<!--         标记
            公司：中裕广恒科技股份有限公司
            项目：资产管理系统
            编程人员：研发部郭帅昌
            时间：2018-8-10
        -->
        */
public class Company /*extends middleware*/{

    private int c_id;//运维公司ID (自增)
    private String c_name;//运维公司的名字
    private String c_phone;//电话
    private String c_head;//负责人
    private String c_head_phone;//负责人电话

    public String getC_head() {
        return c_head;
    }

    public void setC_head(String c_head) {
        this.c_head = c_head;
    }

    public String getC_head_phone() {
        return c_head_phone;
    }

    public void setC_head_phone(String c_head_phone) {
        this.c_head_phone = c_head_phone;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_phone() {
        return c_phone;
    }

    public void setC_phone(String c_phone) {
        this.c_phone = c_phone;
    }

    @Override
    public String toString() {
        return "Company{" +
                "c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                ", c_phone='" + c_phone + '\'' +
                '}';
    }
}
