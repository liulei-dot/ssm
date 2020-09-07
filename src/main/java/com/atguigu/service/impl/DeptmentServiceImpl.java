package com.atguigu.service.impl;

import com.atguigu.dao.DeptmentMapper;
import com.atguigu.domain.Deptment;
import com.atguigu.service.DeptmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liulei
 * @create 2020-09-07 9:16
 */
@Service
public class DeptmentServiceImpl implements DeptmentService {
    @Autowired
    private DeptmentMapper deptmentMapper;
    @Override
    public List<Deptment> getDepts() {
        return deptmentMapper.selectByExample(null);
    }
}
