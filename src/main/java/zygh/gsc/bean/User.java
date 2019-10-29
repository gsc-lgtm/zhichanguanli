package zygh.gsc.bean;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-12-01 15:47
 */

public class User {
    private Integer user_id;
    private String user_name;
    private  String user_password;
    private String user_level;
    private String user_level_head;
    private Integer c_id;
    private String user_cardholder;

    public String getUser_cardholder() {
        return user_cardholder;
    }

    public void setUser_cardholder(String user_cardholder) {
        this.user_cardholder = user_cardholder;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getUser_level() {
        return user_level;
    }

    public void setUser_level(String user_level) {
        this.user_level = user_level;
    }

    public String getUser_level_head() {
        return user_level_head;
    }

    public void setUser_level_head(String user_level_head) {
        this.user_level_head = user_level_head;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_level='" + user_level + '\'' +
                ", user_level_head='" + user_level_head + '\'' +
                ", c_id=" + c_id +
                ", user_cardholder='" + user_cardholder + '\'' +
                '}';
    }
}
