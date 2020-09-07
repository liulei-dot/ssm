package com.atguigu.dao;

import com.atguigu.domain.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author Liulei
 * @create 2020-09-06 15:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmployeeMapperTest {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private SqlSession sqlSession;

    @Test
    public void countByExample() {
    }

    @Test
    public void deleteByExample() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        for(int i=0;i<1000;i++){
            String name=UUID.randomUUID().toString().substring(0,4);
            int did = new Random().nextInt(6);
            if(did==0)
                did=1;

            Employee employee=new Employee(null, name, String.valueOf(new Random().nextInt(1)),name+"@aiguigu.com",did,null);
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            mapper.insert(employee);
        }
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void selectByExampleWithDept() {
    }

    @Test
    public void selectByPrimaryKeyWithDept() {
        Employee employee = employeeMapper.selectByPrimaryKeyWithDept(1);
        System.out.println(employee.getdId());
        System.out.println(employee.getDeptment());
    }

    @Test
    public void updateByExampleSelective() {
    }

    @Test
    public void updateByExample() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}
