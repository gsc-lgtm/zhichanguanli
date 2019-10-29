package zygh.gsc.bean;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-08-14 08:51
 */

public class middleware extends Region{
    private int m_id; //中间件id
   // private int r_id;//区域id
    private int c_id;//公司id

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    @Override
    public String toString() {
        return "middleware{" +
                "m_id=" + m_id +
              //  ", r_id=" + r_id +
                ", c_id=" + c_id +
                '}';
    }
}
