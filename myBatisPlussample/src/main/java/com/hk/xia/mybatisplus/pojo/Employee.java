package com.hk.xia.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author wang.yubin
 * @date 2019/7/30
 * @description 雇员类
 */
@TableName(value = "employee")
public class Employee {

    @TableId(value = "eId")
    private Long eId;

    @TableField(value = "eName")
    private String eName;

    @TableField(value = "stageName")
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
