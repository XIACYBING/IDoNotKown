package com.hk.xia.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.sun.org.apache.bcel.internal.generic.LOOKUPSWITCH;
import lombok.Data;
import lombok.Lombok;

import java.io.Serializable;

/**
 * @author wang.yubin
 * @date 2019/7/30
 * @description 雇主类
 */
@Data
@TableName(value = "employer")
public class Employer extends Model<Employer> {

    @TableId(value = "bId",type = IdType.AUTO)
    private Long bId;

    @TableField(value = "bName")
    private String bName;

    @Override
    protected Serializable pkVal(){
        return bId;
    }

}
