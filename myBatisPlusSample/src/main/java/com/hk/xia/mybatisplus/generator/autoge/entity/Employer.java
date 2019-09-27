package com.hk.xia.mybatisplus.generator.autoge.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 雇主表
 * </p>
 *
 * @author wang.yubin
 * @since 2019-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Employer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "bId", type = IdType.AUTO)
    private Integer bId;

    @TableField("bName")
    private String bName;


}
