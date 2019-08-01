package com.hk.xia.mybatisplus.generator.mybatis.dao;

import com.hk.xia.mybatisplus.generator.mybatis.pojo.HkEmployee;
import com.hk.xia.mybatisplus.generator.mybatis.pojo.HkEmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HkEmployeeMapper {
    long countByExample(HkEmployeeExample example);

    int deleteByExample(HkEmployeeExample example);

    int deleteByPrimaryKey(Integer hkid);

    int insert(HkEmployee record);

    int insertSelective(HkEmployee record);

    List<HkEmployee> selectByExample(HkEmployeeExample example);

    HkEmployee selectByPrimaryKey(Integer hkid);

    int updateByExampleSelective(@Param("record") HkEmployee record, @Param("example") HkEmployeeExample example);

    int updateByExample(@Param("record") HkEmployee record, @Param("example") HkEmployeeExample example);

    int updateByPrimaryKeySelective(HkEmployee record);

    int updateByPrimaryKey(HkEmployee record);
}