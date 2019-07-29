package com.hk.xia.tkmybatis.sample.pojo;

/**
 * @author wang.yubin
 * @date 2019/7/29
 * @description TkMyBatis的测试Pojo
 */
public class Employee {

    private Long eId;

    private String eName;

    private String stageName;

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", eName='" + eName + '\'' +
                ", stageName='" + stageName + '\'' +
                '}';
    }
}
