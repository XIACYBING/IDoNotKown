package com.hk.xia.tkmybatis.sample.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wang.yubin
 * @date 2019/7/29
 * @description 雇员实体类
 */

@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "eId")
    private Long eId;
    
    @Column(name = "eName")
    private String eName;

    @Column(name = "stageName")
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
