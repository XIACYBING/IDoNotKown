package com.hk.xia.spring.pojo;

import lombok.Data;

/**
 * @author wang.yubin
 * @date 2019/9/5
 * @description 测试请求参数和对象映射的Pojo类（本来应该是DTO）
 */
@Data
public class Employee {

    private Long eId;

    private String eName;

    private String stageName;

}
