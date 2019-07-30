package com.hk.xia.mybatisplus.pojo;

/**
 * @author wang.yubin
 * @date 2019/7/30
 * @description
 */
public class Employer {

    private Long bId;

    private String bName;

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
