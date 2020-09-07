package com.atguigu.service;

import com.atguigu.domain.Employee;

import java.util.List;

/**
 * @author Liulei
 * @create 2020-09-06 16:22
 */
public interface EmployeeService{
    List<Employee> getAll();

    boolean addEmp(Employee employee);

    boolean checkuser(String empName);

    Employee getEmp(Integer id);
}
