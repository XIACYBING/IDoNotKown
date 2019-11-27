package com.hk.bussiness.develop.crm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wang.yubin
 * @date 2019/11/21
 * @description 对象引用的一些关系实验
 */
@SuppressWarnings("unused")
public class ObjectReference {

    private static final Logger logger = LoggerFactory.getLogger(ObjectReference.class);

    public static void main(String[] args) {
        Long a = 10L;
        List<Long> b = new ArrayList<>(Arrays.asList(1L, 2L));
        logger.info("a:[{}],b:[{}]", a, b);
        ReferenceClass referenceClass = new ReferenceClass(a, b);
        /*从输出结果可以发现，包装类不是引用传递*/
        logger.info("modifiedA:[{}],modifiedB:[{}]", a, b);

        ObjectReference objectReference = new ObjectReference(a, b);
        logger.info("modifiedA:[{}],modifiedB:[{}]", a, b);

        Integer c = 11;
        objectReference.changeNumber(c);
        /*包装类在类之内传递的也不是引用*/
        logger.info("c:[{}]", c);
    }

    private ObjectReference(Long testNumber, List<Long> testList) {
        testNumber += 1L;
        testList.add(3L);
        testList.add(4L);
        logger.info("testNumber:[{}]", testNumber);
        this.changeNumber(testNumber.intValue());
        logger.info("modifiedTestNumber:[{}]", testNumber);
    }

    private void changeNumber(Integer testNumber) {
        testNumber += 10;
    }

}

class ReferenceClass {

    ReferenceClass(Long testNumber, List<Long> testList) {
        testNumber += 1L;
        testList.remove(testList.size() - 1);
    }

}