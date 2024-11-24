package com.employee.details.management.service.controller;

import com.employee.details.management.service.model.EmployeeModel;
import com.employee.details.management.service.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @InjectMocks
    EmployeeController controller;

    @Mock
    private EmployeeService service;

    @Test
    public void test1(){
        Mockito.when(service.getAllEmployees()).thenReturn(Collections.emptyList());
        controller.getAllEmployees();
        Mockito.when(service.getEmployeeById(Mockito.anyInt())).thenReturn(new EmployeeModel());
        controller.getEmployeeById(1);
        Mockito.when(service.getEmployeeByDepartment(Mockito.anyInt())).thenReturn(Collections.emptyList());
        controller.getEmployeeByDepartment(1);
        Mockito.when(service.getSearchEmployee(Mockito.anyString())).thenReturn(Collections.emptyList());
        controller.getSearchEmployee("test");
        Mockito.when(service.updateEmployee(Mockito.any())).thenReturn(new EmployeeModel());
        controller.addEmployeeDetail(new EmployeeModel());
        controller.updateEmployeeDetail(new EmployeeModel());
        controller.deleteEmployeeDetail(1);
    }
}
