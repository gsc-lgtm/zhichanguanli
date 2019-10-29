package zygh.gsc.bean;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-11-13 13:41
 */

public class Pipe {
    private int pipe_id;
    private String pipe_name;
    private String pipe_time;
    private double pipe_pipe;
    private String  pipe_category;

    @Override
    public String toString() {
        return "Pipe{" +
                "pipe_id=" + pipe_id +
                ", pipe_name='" + pipe_name + '\'' +
                ", pipe_time='" + pipe_time + '\'' +
                ", pipe_pipe=" + pipe_pipe +
                ", pipe_category='" + pipe_category + '\'' +
                '}';
    }

    public int getPipe_id() {
        return pipe_id;
    }

    public void setPipe_id(int pipe_id) {
        this.pipe_id = pipe_id;
    }

    public String getPipe_name() {
        return pipe_name;
    }

    public void setPipe_name(String pipe_name) {
        this.pipe_name = pipe_name;
    }

    public String getPipe_time() {
        return pipe_time;
    }

    public void setPipe_time(String pipe_time) {
        this.pipe_time = pipe_time;
    }

    public double getPipe_pipe() {
        return pipe_pipe;
    }

    public void setPipe_pipe(double pipe_pipe) {
        this.pipe_pipe = pipe_pipe;
    }

    public String getPipe_category() {
        return pipe_category;
    }

    public void setPipe_category(String pipe_category) {
        this.pipe_category = pipe_category;
    }
}