package zygh.gsc.bean;

/*<!--         标记
            公司：中裕广恒科技股份有限公司
            项目：资产管理系统
            编程人员：研发部郭帅昌
            时间：2018-8-10
        -->*/
public class Daoroad {
    private Integer d_uid;//道路ID （自增）
    private Integer r_id;//区域id
    private String d_name;//道路名称
    private String d_starting;//道路起点
    private String d_end;//道路终点
    private String d_length;//道路长度
    private Integer t_id;//道路类别

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public void setD_uid(Integer d_uid) {
        this.d_uid = d_uid;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_starting() {
        return d_starting;
    }

    public void setD_starting(String d_starting) {
        this.d_starting = d_starting;
    }

    public String getD_end() {
        return d_end;
    }

    public void setD_end(String d_end) {
        this.d_end = d_end;
    }

    public String getD_length() {
        return d_length;
    }

    public void setD_length(String d_length) {
        this.d_length = d_length;
    }

    @Override
    public String toString() {
        return "Daoroad{" +
                "d_uid=" + d_uid +
                ", r_id=" + r_id +
                ", d_name='" + d_name + '\'' +
                ", d_starting='" + d_starting + '\'' +
                ", d_end='" + d_end + '\'' +
                ", d_length='" + d_length + '\'' +
                '}';
    }
}
