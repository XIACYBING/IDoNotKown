package com.hk.xia.mybatisplus.test;

import com.hk.xia.mybatisplus.mapper.EmployeeMapper;

import com.hk.xia.mybatisplus.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author wang.yubin
 * @date 2019/7/30
 * @description MyBatisPlus测试Demo
 */
public class MyBatisPlusTest {

    private static Logger logger = LoggerFactory.getLogger(MyBatisPlusTest.class);

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("MyBatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession(false);
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee>  listEmployee = employeeMapper.selectList(null);
        for (Employee ee : listEmployee){
            logger.info("{}",ee.toString());
        }
    }

}
