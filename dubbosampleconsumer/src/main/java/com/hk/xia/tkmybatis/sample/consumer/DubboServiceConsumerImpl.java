package com.hk.xia.tkmybatis.sample.consumer;

import com.hk.xia.dubbo.sample.api.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wang.yubin
 * @date 2019/7/19
 * @description 用来判断Provider和Consumer之间配置区别的一个测试类（如果想要成为提供者，只需要在配置文件里面加上<dubbo:protocol/>和<dubbo:service/>的相关配置信息即可）
 */
public class DubboServiceConsumerImpl implements DubboService {

    private static Logger logger = LoggerFactory.getLogger(DubboServiceConsumerImpl.class);

    @Override
    public String dubboSayHello(String str) {
        logger.info("作为Provider的Consumer被调用");
        return "Dubbo Consumer Provider,say:" + str;
    }

}
