package com.hk.xia.mybatisplus.test;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.hk.xia.mybatisplus.mapper.EmployeeMapper;

import com.hk.xia.mybatisplus.pojo.Employee;
import com.hk.xia.mybatisplus.pojo.Employer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.dc.pr.PRError;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wang.yubin
 * @date 2019/7/30
 * @description MyBatisPlus测试Demo
 */
public class MyBatisPlusTest {

    private static Logger logger = LoggerFactory.getLogger(MyBatisPlusTest.class);

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("MyBatis.xml");
        SqlSessionFactory sessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream, null, null);
        SqlSession sqlSession = sessionFactory.openSession(false);
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("eId","1");
        logger.info(employeeMapper.selectOne(wrapper).toString());


        sqlSession.close();

    }

}
