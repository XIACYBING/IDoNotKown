package com.hk.xia.mybatisplus.test;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.hk.xia.mybatisplus.mapper.EmployeeMapper;

import com.hk.xia.mybatisplus.pojo.Employee;
import com.hk.xia.mybatisplus.pojo.Employer;
import com.hk.xia.mybatisplus.service.EmployeeService;
import com.hk.xia.mybatisplus.service.impl.EmployeeServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.dc.pr.PRError;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wang.yubin
 * @date 2019/7/30
 * @description MyBatisPlus测试Wrapper的Demo
 */
public class MyBatisPlusTest {

    private static Logger logger = LoggerFactory.getLogger(MyBatisPlusTest.class);

    private static final Long ENTITY_MIN = 0L;

    private static final Long ENTITY_MAX = 10000L;

    private static final int LOOP_MIN = 0;

    private static final int LOOP_MAX = 10;

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("MyBatis.xml");
        SqlSessionFactory sessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream, null, null);
       /* EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("eId","1");
        logger.info(employeeMapper.selectOne(wrapper).toString());*/

        EmployeeService employeeService = new EmployeeServiceImpl();
        List<Employee> listEe = new ArrayList<>(10000);
        Long[] time = new Long[10];
        Long count = 0L;
        StringBuilder timeOut = new StringBuilder();

        for (int i = LOOP_MIN;i<LOOP_MAX;i++){

            for (Long l = ENTITY_MIN;l<ENTITY_MAX;l++){
                Employee employee = new Employee();
                employee.setEName(l.toString() + ":" + i);
                employee.setStageName("s" + l.toString() + ":" + i);
                listEe.add(employee);
            }

            SqlSession sqlSession = sessionFactory.openSession(false);
            Long startTime = System.currentTimeMillis();
            employeeService.saveBatch(listEe);
            Long endTime = System.currentTimeMillis();
            sqlSession.close();
            time[i] = endTime - startTime;
            count += time[i];
            timeOut.append(time[i]).append("、");


            listEe.clear();
        }

        logger.info(timeOut.toString());
        logger.info("Average Time :" + count/10);

    }

}
