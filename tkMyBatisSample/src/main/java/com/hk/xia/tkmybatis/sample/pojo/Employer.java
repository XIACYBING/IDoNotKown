package com.hk.xia.tkmybatis.sample.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wang.yubin
 * @date 2019/7/30
 * @description 雇主实体类
 */
@Table(name = "employer")
public class Employer {

    @Id
    @Column(name = "bId")
    private Long bId;

    @Column(name = "bName")
    private String bName;

    public Employer() {

    }

    public Employer(Long bId) {
        this.bId = bId;
    }

    public Employer(Long bId, String bName) {
        this.bId = bId;
        this.bName = bName;
    }

    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "bId=" + bId +
                ", bName='" + bName + '\'' +
                '}';
    }
}
