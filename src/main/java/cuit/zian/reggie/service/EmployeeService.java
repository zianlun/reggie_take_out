package cuit.zian.reggie.service;

import cuit.zian.reggie.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> queryEmployeeByUserName(String username);

    int saveEmployee(Employee employee);
}
