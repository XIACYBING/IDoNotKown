package com.hk.xia.mybatisplus.generator.mapper.pojo;

import javax.persistence.*;

@Table(name = "hk_employee")
public class HkEmployee {
    @Id
    @Column(name = "hkId")
    @GeneratedValue(generator = "JDBC")
    private Integer hkid;

    @Column(name = "hkName")
    private String hkname;

    @Column(name = "hkStageName")
    private String hkstagename;

    public HkEmployee(Integer hkid, String hkname, String hkstagename) {
        this.hkid = hkid;
        this.hkname = hkname;
        this.hkstagename = hkstagename;
    }

    public HkEmployee() {
        super();
    }

    /**
     * @return hkId
     */
    public Integer getHkid() {
        return hkid;
    }

    /**
     * @param hkid
     */
    public void setHkid(Integer hkid) {
        this.hkid = hkid;
    }

    /**
     * @return hkName
     */
    public String getHkname() {
        return hkname;
    }

    /**
     * @param hkname
     */
    public void setHkname(String hkname) {
        this.hkname = hkname;
    }

    /**
     * @return hkStageName
     */
    public String getHkstagename() {
        return hkstagename;
    }

    /**
     * @param hkstagename
     */
    public void setHkstagename(String hkstagename) {
        this.hkstagename = hkstagename;
    }
}