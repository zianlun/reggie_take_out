package cuit.zian.reggie.service;

import com.github.pagehelper.PageInfo;
import cuit.zian.reggie.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> queryEmployeeByUserName(String username);

    int saveEmployee(Employee employee);


    PageInfo<Employee> queryEmployeeToPage(Integer pageNum, Integer pageSize, String name);
}
