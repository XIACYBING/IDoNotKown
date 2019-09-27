package com.hk.xia.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wang.yubin
 * @date 2019/7/30
 * @description 雇员类
 */
@Data
@TableName(value = "employee")
public class Employee {

    @TableId(value = "eId",type = IdType.AUTO)
    private Long eId;

    @TableField(value = "eName")
    private String eName;

    @TableField(value = "stageName")
    private String stageName;

}
