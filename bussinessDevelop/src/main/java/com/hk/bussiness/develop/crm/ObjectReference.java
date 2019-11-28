package com.hk.bussiness.develop.crm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author wang.yubin
 * @date 2019/11/21
 * @description 对象引用的一些关系实验
 */
@SuppressWarnings("unused")
public class ObjectReference {

    private static final Logger logger = LoggerFactory.getLogger(ObjectReference.class);

    public Date currentDate = new Date(System.currentTimeMillis());

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
        /*包装类在类之内传递的是引用，但是在做运算符操作时会进行自动拆箱和自动装箱，产生了新对象，导致原来的运算结果体现不到原对象上*/
        logger.info("c:[{}]", c);

        Date currentDate = new Date(System.currentTimeMillis());
        /*currentDate:[Thu Nov 28 10:41:55 CST 2019] */
        logger.info("currentDate:[{}]", currentDate);
        Date modifiedDate = objectReference.modifyTime(currentDate);
        /*currentDate:[Thu Nov 28 10:43:35 CST 2019],modifiedDate:[Thu Nov 28 10:43:35 CST 2019]*/
        logger.info("currentDate:[{}],modifiedDate:[{}]", currentDate, modifiedDate);

        /*直接赋值方式传递的还是引用，对thisDate的任何修改都会反应到objectReference.currentDate上，如果需要创建对象的话，用new Date()*/
        logger.info("objectReference.currentDate:[{}]", objectReference.currentDate);
        Date thisDate = objectReference.currentDate;
        objectReference.modifyTime(thisDate);
        logger.info("thisDate:[{}], objectReference.currentDate:[{}]", thisDate, objectReference.currentDate);
    }

    private Date modifyTime(Date currentDate) {
        currentDate.setTime(currentDate.getTime() + 100000L);
        return currentDate;
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
        testNumber = testNumber + 10;
    }

}

class ReferenceClass {

    ReferenceClass(Long testNumber, List<Long> testList) {
        testNumber += 1L;
        testList.remove(testList.size() - 1);
    }

}