package zygh.gsc.bean;
    /*     标记
            公司：中裕广恒科技股份有限公司
            项目：资产管理系统
            编程人员：研发部郭帅昌
            时间：2018-8-6
        */

import java.util.List;

public class Assets {
    private int a_id;//id
    private int d_uid;//道路关联id
    private String a_category;//类别
    private String a_attribute;//属性
    private String a_ip;//IP地址
    private String a_model;//品牌型号
    private String a_brandname;//品牌名称
    private String a_environment;//部署环境
    private String a_number;//序号
    private String a_date;//建设日期
    private String a_way;//发布方式
    private String a_num;//模块数量
    private String a_electricity;//供电方式
    private String a_datasource;//数据源
    private String a_precision;//经度
    private String a_latitude;//纬度
    private String a_location;//位置
    private String a_use;//主要用途
    private String a_system;//所属系统
    private String a_subsystem;//子系统
    private String c_id;//所诉公司
    private String a_normal;//是否正常
    private String a_enable;//是否启用
    private  int rozzer_id;


    public String getA_enable() {
        return a_enable;
    }

    public void setA_enable(String a_enable) {
        this.a_enable = a_enable;
    }

    public int getRozzer_id() {
        return rozzer_id;
    }

    public void setRozzer_id(int rozzer_id) {
        this.rozzer_id = rozzer_id;
    }

    public int getD_uid() {
        return d_uid;
    }

    public void setD_uid(int d_uid) {
        this.d_uid = d_uid;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_category() {
        return a_category;
    }

    public void setA_category(String a_category) {
        this.a_category = a_category;
    }

    public String getA_attribute() {
        return a_attribute;
    }

    public void setA_attribute(String a_attribute) {
        this.a_attribute = a_attribute;
    }

    public String getA_ip() {
        return a_ip;
    }

    public void setA_ip(String a_ip) {
        this.a_ip = a_ip;
    }

    public String getA_model() {
        return a_model;
    }

    public void setA_model(String a_model) {
        this.a_model = a_model;
    }

    public String getA_brandname() {
        return a_brandname;
    }

    public void setA_brandname(String a_brandname) {
        this.a_brandname = a_brandname;
    }

    public String getA_environment() {
        return a_environment;
    }

    public void setA_environment(String a_environment) {
        this.a_environment = a_environment;
    }

    public String getA_number() {
        return a_number;
    }

    public void setA_number(String a_number) {
        this.a_number = a_number;
    }

    public String getA_date() {
        return a_date;
    }

    public void setA_date(String a_date) {
        this.a_date = a_date;
    }

    public String getA_way() {
        return a_way;
    }

    public void setA_way(String a_way) {
        this.a_way = a_way;
    }

    public String getA_num() {
        return a_num;
    }

    public void setA_num(String a_num) {
        this.a_num = a_num;
    }

    public String getA_electricity() {
        return a_electricity;
    }

    public void setA_electricity(String a_electricity) {
        this.a_electricity = a_electricity;
    }

    public String getA_datasource() {
        return a_datasource;
    }

    public void setA_datasource(String a_datasource) {
        this.a_datasource = a_datasource;
    }

    public String getA_precision() {
        return a_precision;
    }

    public void setA_precision(String a_precision) {
        this.a_precision = a_precision;
    }

    public String getA_latitude() {
        return a_latitude;
    }

    public void setA_latitude(String a_latitude) {
        this.a_latitude = a_latitude;
    }

    public String getA_location() {
        return a_location;
    }

    public void setA_location(String a_location) {
        this.a_location = a_location;
    }

    public String getA_use() {
        return a_use;
    }

    public void setA_use(String a_use) {
        this.a_use = a_use;
    }

    public String getA_system() {
        return a_system;
    }

    public void setA_system(String a_system) {
        this.a_system = a_system;
    }

    public String getA_subsystem() {
        return a_subsystem;
    }

    public void setA_subsystem(String a_subsystem) {
        this.a_subsystem = a_subsystem;
    }


    public String getA_normal() {
        return a_normal;
    }

    public void setA_normal(String a_normal) {
        this.a_normal = a_normal;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    @Override
    public String toString() {
        return "Assets{" +
                "a_id=" + a_id +
                ", d_uid=" + d_uid +
                ", a_category='" + a_category + '\'' +
                ", a_attribute='" + a_attribute + '\'' +
                ", a_ip='" + a_ip + '\'' +
                ", a_model='" + a_model + '\'' +
                ", a_brandname='" + a_brandname + '\'' +
                ", a_environment='" + a_environment + '\'' +
                ", a_number='" + a_number + '\'' +
                ", a_date='" + a_date + '\'' +
                ", a_way='" + a_way + '\'' +
                ", a_num='" + a_num + '\'' +
                ", a_electricity='" + a_electricity + '\'' +
                ", a_datasource='" + a_datasource + '\'' +
                ", a_precision='" + a_precision + '\'' +
                ", a_latitude='" + a_latitude + '\'' +
                ", a_location='" + a_location + '\'' +
                ", a_use='" + a_use + '\'' +
                ", a_system='" + a_system + '\'' +
                ", a_subsystem='" + a_subsystem + '\'' +
                ", c_id='" + c_id + '\'' +
                ", a_normal='" + a_normal + '\'' +
                ", rozzer_id=" + rozzer_id +
                '}';
    }
}
