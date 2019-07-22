package com.hk.xia.dubbo.sample.providerTwo;

import com.hk.xia.dubbo.sample.api.DubboService;

/**
 * @author wang.yubin
 * @date 2019/7/19
 * @description 测试如果服务列表里面有两个相同接口，consumer会去调用哪一个(Consumer会基于软负载均衡算法去调用方法)
 */
public class DubboServiceImplTwo implements DubboService {

    @Override
    public String dubboSayHello(String str) {
        return "Dubbo Provider Two Say:" + str;
    }

}
