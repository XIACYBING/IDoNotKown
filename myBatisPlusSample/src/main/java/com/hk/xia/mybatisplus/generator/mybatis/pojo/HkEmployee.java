package com.hk.xia.mybatisplus.generator.mybatis.pojo;

public class HkEmployee {
    private Integer hkid;

    private String hkname;

    private String hkstagename;

    public HkEmployee(Integer hkid, String hkname, String hkstagename) {
        this.hkid = hkid;
        this.hkname = hkname;
        this.hkstagename = hkstagename;
    }

    public HkEmployee() {
        super();
    }

    public Integer getHkid() {
        return hkid;
    }

    public void setHkid(Integer hkid) {
        this.hkid = hkid;
    }

    public String getHkname() {
        return hkname;
    }

    public void setHkname(String hkname) {
        this.hkname = hkname;
    }

    public String getHkstagename() {
        return hkstagename;
    }

    public void setHkstagename(String hkstagename) {
        this.hkstagename = hkstagename;
    }
}