package cuit.zian.reggie.controller;

import com.github.pagehelper.PageInfo;
import cuit.zian.reggie.common.Result;
import cuit.zian.reggie.dto.LoginParam;
import cuit.zian.reggie.pojo.Employee;
import cuit.zian.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Value("${employee.init-password}")
    private String initPassword;

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
    @GetMapping("/page")
    public Result<PageInfo<Employee>> page(@RequestParam(value="page", defaultValue = "1") Integer page,
                                       @RequestParam( value="pageSize ", defaultValue = "5") Integer pageSize ,
                                       @RequestParam(value="name", required = false) String username){
        PageInfo<Employee> pageInfo =  employeeService.queryEmployeeToPage(page, pageSize, username);
        return Result.success(pageInfo);
    }

    @PostMapping
    public Result<String> addEmployee(HttpServletRequest request, @RequestBody Employee employee){
        log.info("员工信息: {}",employee);
        /*
        * 数据处理
        * 设置初始密码
        * 设置创建时间
        * 设置更新时间
        * 设置创建者id
        * 设置更新者id
        * */
        employee.setPassword(DigestUtils.md5DigestAsHex(initPassword.getBytes()));
        employee.setCreateTime(new Date());
        employee.setUpdateTime(new Date());
        employee.setCreateUser((Long)request.getSession().getAttribute("employeeId"));
        employee.setUpdateUser((Long)request.getSession().getAttribute("employeeId"));
        int result =  employeeService.saveEmployee(employee);
        if(result <= 0) {
            return Result.failed("创建员工失败");
        }
        return Result.success("添加员工成功");
    }

    @PutMapping
    public Result<String> updateEmployee(HttpServletRequest request, @RequestBody Employee employee){
        employee.setUpdateTime(new Date());
        employee.setUpdateUser((Long)request.getSession().getAttribute("employeeId"));
        int result = employeeService.updateEmployee(employee);
        if(result <= 0){
            return Result.failed("更新失败");
        }
        return Result.success("更新成功");
    }

    @GetMapping("{id}")
    public Result<Employee> employeeInfo(@PathVariable Long id){
        return Result.success(employeeService.queryEmployeeById(id));
    }
}
