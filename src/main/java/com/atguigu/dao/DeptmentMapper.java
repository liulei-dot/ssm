package com.atguigu.dao;

import com.atguigu.domain.Deptment;
import com.atguigu.domain.DeptmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptmentMapper {
    int countByExample(DeptmentExample example);

    int deleteByExample(DeptmentExample example);

    int deleteByPrimaryKey(Integer deptId);

    int insert(Deptment record);

    int insertSelective(Deptment record);

    List<Deptment> selectByExample(DeptmentExample example);

    Deptment selectByPrimaryKey(Integer deptId);

    int updateByExampleSelective(@Param("record") Deptment record, @Param("example") DeptmentExample example);

    int updateByExample(@Param("record") Deptment record, @Param("example") DeptmentExample example);

    int updateByPrimaryKeySelective(Deptment record);

    int updateByPrimaryKey(Deptment record);
}