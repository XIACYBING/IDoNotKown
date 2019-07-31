package com.hk.xia.tkmybatis.sample.test;

import com.hk.xia.tkmybatis.sample.mapper.EmployerMapper;
import com.hk.xia.tkmybatis.sample.pojo.Employer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wang.yubin
 * @date 2019/7/31
 * @description 对TkMyBatis的基础CRUD的测试
 */
public class CrudTest {

    private static final Logger logger = LoggerFactory.getLogger(CrudTest.class);

    private static final Long MIN_DELETE_NUMBER = 120350L;

    private static final Long MAX_DELETE_NUMBER = 130350L;

    private static final int LOOP_START = 0;

    private static final int LOOP_END = 10;

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("MyBatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        Employer employer = new Employer();
        Long startTime;
        Long endTime;
        Long[] milis = new Long[10];
        for (int i = LOOP_START; i < LOOP_END;i++){

            SqlSession sqlSession = sessionFactory.openSession(false);
            MapperHelper mapperHelper = new MapperHelper();
            // 注册自己项目中使用的通用Mapper接口，这里没有默认值，必须手动注册
            mapperHelper.registerMapper(Mapper.class);
            //配置完成后，执行下面的操作
            mapperHelper.processConfiguration(sqlSession.getConfiguration());
            EmployerMapper employerMapper = sqlSession.getMapper(EmployerMapper.class);

            startTime = System.currentTimeMillis();
            for (Long l = MIN_DELETE_NUMBER;l < MAX_DELETE_NUMBER;l++){
                /*插入数据*/
                /*employer.setbName("insertName" + l);
                employerMapper.insert(employer);*/

                /*查询出的数据并不需要使用，所以不作处理*/
                /*employerMapper.selectByPrimaryKey(l);*/

                /*更新名称*/
                /*employer.setbId(l);
                employer.setbName("insertBName" + l);
                employerMapper.updateByPrimaryKey(employer);*/

                /*删除数据*/
                employerMapper.deleteByPrimaryKey(l);

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
        logger.info("Average millis : {}",count/10);
    }

}
