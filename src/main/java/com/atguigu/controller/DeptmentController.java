package com.atguigu.controller;

import com.atguigu.domain.Deptment;
import com.atguigu.service.DeptmentService;
import com.atguigu.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Liulei
 * @create 2020-09-07 9:16
 */
@Controller
public class DeptmentController {
    @Autowired
    private DeptmentService deptmentService;

    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Deptment> depts=deptmentService.getDepts();
        return Msg.success().add("depts",depts);
    }
}
