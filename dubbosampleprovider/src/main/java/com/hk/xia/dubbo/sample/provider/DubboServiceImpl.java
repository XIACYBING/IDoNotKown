package com.hk.xia.dubbo.sample.provider;

import com.hk.xia.dubbo.sample.api.DubboService;

/**
 * @author wang.yubin
 * @date 2019/7/19
 * @description 服务提供者提供的方法
 */
public class DubboServiceImpl implements DubboService {

    @Override
    public String dubboSayHello(String str) {
        System.out.println("dubboSayHelloIn");
        return "Dubbo Provider Say:" + str;
    }
}
