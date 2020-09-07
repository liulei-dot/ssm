package com.atguigu.service.impl;

import com.atguigu.dao.EmployeeMapper;
import com.atguigu.domain.Employee;
import com.atguigu.domain.EmployeeExample;
import com.atguigu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liulei
 * @create 2020-09-06 16:18
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getAll() {
        //查询所有员工
        return employeeMapper.selectByExampleWithDept(null);
    }

    @Override
    public boolean addEmp(Employee employee) {
        int status = employeeMapper.insertSelective(employee);
        if(status>0)
            return true;
        return false;
    }

    @Override
    public boolean checkuser(String empName) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria().andEmpNameEqualTo(empName);
        int status = employeeMapper.countByExample(employeeExample);
        if(status==0)
            return true;
        return false;
    }

    @Override
    public Employee getEmp(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }
}
