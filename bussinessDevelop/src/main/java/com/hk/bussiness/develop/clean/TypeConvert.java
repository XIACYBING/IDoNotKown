package com.hk.bussiness.develop.clean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wang.yubin
 * @date 2019/12/10
 * @description 类型转换测试
 */
public class TypeConvert {

    public static void main(String[] args) {
        Map<String, Object> convertMap = new HashMap<>(1);
        convertMap.put("convertInteger", 10);
        System.out.println(convertMap.get("convertInteger"));
    }

}
