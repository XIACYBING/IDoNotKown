package com.hk.xia.tkmybatis.sample.test;

import com.hk.xia.tkmybatis.sample.mapper.EmployeeMapper;
import com.hk.xia.tkmybatis.sample.mapper.EmployerMapper;
import com.hk.xia.tkmybatis.sample.pojo.Employee;
import com.hk.xia.tkmybatis.sample.pojo.Employer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author wang.yubin
 * @date 2019/7/30
 * @description TkMyBatis测试Demo
 */
public class MyBatisTest {

    private static Logger logger = LoggerFactory.getLogger(MyBatisTest.class);

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("MyBatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession(false);

        MapperHelper mapperHelper = new MapperHelper();
        //特殊配置
        Config config = new Config();
        //具体支持的参数看后面的文档
        config.setEnableMethodAnnotation(true);
        //设置配置
        mapperHelper.setConfig(config);
        // 注册自己项目中使用的通用Mapper接口，这里没有默认值，必须手动注册
        mapperHelper.registerMapper(Mapper.class);
        //配置完成后，执行下面的操作
        mapperHelper.processConfiguration(sqlSession.getConfiguration());

        /*Employee操作*/
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employeeInfo = new Employee();
        employeeInfo.seteId(2L);
        employeeInfo.seteName("stiwu");
        employeeInfo.setStageName("laojues");
        /*插入数据，但是不提交，因为autoCommit为false*/
        /*int insertResult = employeeMapper.insert(employeeInfo);
        logger.debug("insertResult: " + insertResult);*/

        /*查询所有*/
        List<Employee> listEe = employeeMapper.selectAll();
        for (Employee em : listEe){
            logger.debug(em.toString());
        }

        /*example的criteria聚合查询*/
        Example ex = new Example(Employee.class);
        Example.Criteria criteria = ex.createCriteria();
        criteria.andLike("eId","%" + 9L + "%");
        List<Employee> list = employeeMapper.selectByExample(ex);
        for (Employee yee : list){
            logger.info(yee.toString());
        }

    /*Employer操作*/
        EmployerMapper employerMapper = sqlSession.getMapper(EmployerMapper.class);
        List<Employer> listEr = employerMapper.selectAll();
        for (Employer er : listEr){
            logger.debug(er.toString());
        }
        Employer er = new Employer();
        er.setbId(5L);
        /*普通聚合查询，查询符合条件的总数*/
        int count = employerMapper.selectCount(er);
        logger.debug("count:" + count);
        /*example聚合查询，查询符合条件的总数*/
        Example example = new Example(Employer.class);
        example.createCriteria().andGreaterThanOrEqualTo("bId",2L).andLessThanOrEqualTo("bId",6L);
        example.or().andEqualTo("bId",1L);
        int resultCount = employerMapper.selectCountByExample(example);
        logger.debug("resultCount : {}" ,resultCount);

        sqlSession.close();

    }

}
