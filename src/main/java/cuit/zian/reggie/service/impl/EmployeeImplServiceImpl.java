package cuit.zian.reggie.service.impl;

import cuit.zian.reggie.mapper.EmployeeMapper;
import cuit.zian.reggie.pojo.Employee;
import cuit.zian.reggie.pojo.EmployeeExample;
import cuit.zian.reggie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeImplServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> queryEmployeeByUserName(String username) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        return employeeMapper.selectByExample(example);
    }
}
