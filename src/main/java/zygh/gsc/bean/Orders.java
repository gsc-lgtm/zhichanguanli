package zygh.gsc.bean;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-10-24 15:41
 */

public class Orders {
    private int orders_id;
    private int a_id;
    private String orders_time;
    private String  orders_state;
    private String orders_orders_state;

    @Override
    public String toString() {
        return "Orders{" +
                "orders_id=" + orders_id +
                ", a_id=" + a_id +
                ", orders_time='" + orders_time + '\'' +
                ", orders_state='" + orders_state + '\'' +
                ", orders_orders_state='" + orders_orders_state + '\'' +
                '}';
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getOrders_time() {
        return orders_time;
    }

    public void setOrders_time(String orders_time) {
        this.orders_time = orders_time;
    }

    public String getOrders_state() {
        return orders_state;
    }

    public void setOrders_state(String orders_state) {
        this.orders_state = orders_state;
    }

    public String getOrders_orders_state() {
        return orders_orders_state;
    }

    public void setOrders_orders_state(String orders_orders_state) {
        this.orders_orders_state = orders_orders_state;
    }
}
