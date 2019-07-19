package com.hk.xia.sample.consumer;

import com.hk.xia.dubbo.sample.api.DubboService;

/**
 * @author wang.yubin
 * @date 2019/7/19
 * @description 用来判断Provider和Consumer之间配置区别的一个测试类
 */
public class DubboServiceConsumerImpl implements DubboService {

    @Override
    public String dubboSayHello(String str) {
        return "This is Consumer Provider,say :" + str;
    }

}
