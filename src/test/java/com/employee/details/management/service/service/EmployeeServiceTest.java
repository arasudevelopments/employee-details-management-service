package com.employee.details.management.service.service;

import com.employee.details.management.service.entity.Employee;
import com.employee.details.management.service.model.EmployeeModel;
import com.employee.details.management.service.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
    @InjectMocks
    EmployeeService service;

    @Mock
    EmployeeRepository repo;

    @Test
    public void test1(){
        Employee employee = new Employee();
        employee.setDepartmentId(1);
        employee.setDataOfJoining(new Date());
        employee.setName("test");
        employee.setAge(1);
        employee.setEmail("test@gmail.com");
        employee.setEmployeeId(1);
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setDepartmentId(1);
        employeeModel.setDateOfJoining("2024-11-24");
        employeeModel.setName("test");
        employeeModel.setAge(1);
        employeeModel.setEmail("test@gmail.com");
        employeeModel.setEmployeeId(1);
        employeeModel.toString();
        Mockito.when(repo.findByDepartmentId(Mockito.anyInt())).thenReturn(Arrays.asList(employee));
        service.getEmployeeByDepartment(1);
        Mockito.when(repo.findAll()).thenReturn(Arrays.asList(employee));
        service.getAllEmployees();
        Mockito.when(repo.findByEmployeeId(Mockito.anyInt())).thenReturn(employee);
        service.getEmployeeById(1);
        service.deleteEmployee(1);
        Mockito.when(repo.save(Mockito.any())).thenReturn(employee);
        service.updateEmployee(employeeModel);
        Object[] dataArray = new Object[]{1,"test", "test", 3, new Date(),1};
        List<Object> testData = new ArrayList<>();
        testData.add(dataArray);
        Mockito.when(repo.getSearchEmployee(Mockito.anyString())).thenReturn(testData);
        service.getSearchEmployee("test");

    }
}
