package cuit.zian.reggie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cuit.zian.reggie.mapper.EmployeeMapper;
import cuit.zian.reggie.pojo.Employee;
import cuit.zian.reggie.pojo.EmployeeExample;
import cuit.zian.reggie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

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

    @Override
    public int saveEmployee(Employee employee) {
        Long employeeId = (long) Math.abs(UUID.randomUUID().hashCode());
        employee.setId(employeeId);
        return employeeMapper.insert(employee);
    }

    @Override
    public PageInfo<Employee> queryEmployeeToPage(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        if(name != null){
            criteria.andNameLike("%" + name + "%");
        }
        List<Employee> employees = employeeMapper.selectByExample(example);
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);
        return pageInfo;
    }

}
