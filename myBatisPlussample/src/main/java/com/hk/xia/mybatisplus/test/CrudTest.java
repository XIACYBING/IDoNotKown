package com.hk.xia.mybatisplus.test;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.hk.xia.mybatisplus.mapper.EmployeeMapper;
import com.hk.xia.mybatisplus.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wang.yubin
 * @date 2019/7/31
 * @description 对MyBatisPlus的基础CRUD的测试
 */
public class CrudTest {

    private static Logger logger = LoggerFactory.getLogger(CrudTest.class);

    private static final Long MIN_CRUD_NUMBER = 120350L;

    private static final Long MAX_CRUD_NUMBER = 130350L;

    private static final int LOOP_START = 0;

    private static final int LOOP_END = 10;

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("MyBatis.xml");
        SqlSessionFactory sessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream,null,null);

        Employee employee = new Employee();
        Long startTime;
        Long endTime;
        Long[] milis = new Long[10];
        for (int i = LOOP_START; i < LOOP_END;i++){

            SqlSession sqlSession = sessionFactory.openSession(false);
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            startTime = System.currentTimeMillis();
            for (Long l = MIN_CRUD_NUMBER;l < MAX_CRUD_NUMBER;l++){
                /*插入数据*/
                employee.setEName("insertName" + i);
                employee.setStageName("insertStageName" + i);
                employeeMapper.insert(employee);

                /*查询出的数据并不需要使用，所以不作处理*/
                /*employeeMapper.selectById(l);*/

                /*更新名称*/
                /*employee.setEId(l);
                employee.setEName("inserrNNnNNnN" + l);
                employeeMapper.updateById(employee);*/

                /*删除数据*/
                /*employeeMapper.deleteById(l);*/

            }
            endTime = System.currentTimeMillis();
            milis[i] = endTime - startTime;
            sqlSession.close();
        }
        StringBuilder millisTime = new StringBuilder();
        Long count = 0L;
        for (Long milli : milis) {
            millisTime.append(milli).append("、");
            count += milli;
        }
        logger.info(millisTime.toString());
        logger.info("Average millis : {}",(double)count/10);
    }

}
