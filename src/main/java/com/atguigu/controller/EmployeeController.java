package com.atguigu.controller;

import com.atguigu.domain.Employee;
import com.atguigu.service.EmployeeService;
import com.atguigu.service.impl.EmployeeServiceImpl;
import com.atguigu.util.Msg;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Liulei
 * @create 2020-09-06 16:17
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /*@RequestMapping("/emps")
    @ResponseBody
    public PageInfo getEmps(@RequestParam(required = false,defaultValue = "0") Integer pn,
                                      @RequestParam(required = false,defaultValue = "5") Integer pageSize,
                                      @RequestParam(required = false,defaultValue = "5") Integer navigateNo,
                                      Model model){
        Page<Employee> page = PageHelper.startPage(pn, pageSize);

        List<Employee> emps = employeeService.getAll();

        PageInfo<Employee> pageInfo = new PageInfo<>(emps, navigateNo);

        //model.addAttribute("pageInfo",pageInfo);
        return pageInfo;
    }*/

    /**
     * 导入jackson包。
     * @param pn
     * @return
     */
    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        // 这不是一个分页查询
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Employee> emps = employeeService.getAll();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(emps, 5);
        Msg msg = Msg.success().add("pageInfo", page);
        System.out.println(msg);
        return msg;
    }
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    @ResponseBody
    public Msg addEmp(@Valid Employee employee,BindingResult result){
        if(result.hasErrors()){
            //校验失败，应该返回失败，在模态框中显示校验失败的错误信息
            Map<String, Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                System.out.println("错误的字段名："+fieldError.getField());
                System.out.println("错误信息："+fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        }else{
            employeeService.addEmp(employee);
            return Msg.success();
        }
    }
    @RequestMapping(value = "/checkuser",method = RequestMethod.POST)
    @ResponseBody
    public Msg checkuser(String empName){
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        if(!empName.matches(regx)){
            return Msg.fail().add("va_msg", "用户名必须是6-16位数字和字母的组合或者2-5位中文");
        }
        boolean status=employeeService.checkuser(empName);
        if(status)
            return Msg.success();
        return Msg.fail().add("va_msg", "用户名不可用");
    }
    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id")Integer id){

        Employee employee = employeeService.getEmp(id);
        return Msg.success().add("emp", employee);
    }

}
