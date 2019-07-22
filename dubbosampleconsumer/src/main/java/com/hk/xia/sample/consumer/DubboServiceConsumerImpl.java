package com.hk.xia.sample.consumer;

import com.hk.xia.dubbo.sample.api.DubboService;

/**
 * @author wang.yubin
 * @date 2019/7/19
 * @description 用来判断Provider和Consumer之间配置区别的一个测试类（如果想要成为提供者，只需要在配置文件里面加上<dubbo:protocol/>和<dubbo:service/>的相关配置信息即可）
 */
public class DubboServiceConsumerImpl implements DubboService {

    @Override
    public String dubboSayHello(String str) {
        return "Dubbo Consumer Provider,say:" + str;
    }

}
