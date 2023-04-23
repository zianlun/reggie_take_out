package cuit.zian.reggie.controller;

import cuit.zian.reggie.common.Result;
import cuit.zian.reggie.dto.LoginParam;
import cuit.zian.reggie.pojo.Employee;
import cuit.zian.reggie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public Result<Employee> login(@RequestBody LoginParam loginParam, HttpServletRequest request) {
        /*
        * 1.将页面提交的password进行md5加密
        * 2.入过没有查询结果结果返回登录失败的结果
        * 3.密码对比，不一致返回登录失败的结果
        * 4.查看员工状态，是否被禁用
        * 5.登录成功，将id存入session并返回登录成功的结果
        * */
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        List<Employee> list = employeeService.queryEmployeeByUserName(username);
        if(list.size() <= 0){
            return Result.failed("用户名不存在");
        }else{
            Employee employee = list.get(0);
            if(!employee.getPassword().equals(password)){
                return Result.failed("密码错误");
            } else{
                if(employee.getStatus() == 0){
                    return Result.forbidden("您的账号已冻结，请联系管理员");
                }
            }
            request.getSession().setAttribute("employeeId",employee.getId());
            return Result.success("登录成功", employee);
        }
    }

    /*
    * 清理session中保存的当前员工的id
    * */
    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request){
        //清理session中的员工id
        request.getSession().removeAttribute("employee");
        return Result.success("注销成功");
    }
}
