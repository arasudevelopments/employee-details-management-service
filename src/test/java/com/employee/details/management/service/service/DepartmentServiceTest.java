package com.employee.details.management.service.service;


import com.employee.details.management.service.entity.Department;
import com.employee.details.management.service.entity.Employee;
import com.employee.details.management.service.model.DepartmentModel;
import com.employee.details.management.service.repository.DepartmentRepository;
import com.employee.details.management.service.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceTest {

    @InjectMocks
    DepartmentService service;

    @Mock
    DepartmentRepository repo;

    @Test
    public void test1(){
        Department department = new Department();
        department.setDepartmentId(1);
        department.setDepartmentName("test");
        department.setDepartmentHead("test");
        department.setCreatedDate(new Date());
        DepartmentModel model = new DepartmentModel();
        model.setDepartmentId(1);
        model.setCreatedDate("2024-11-24");
        model.setDepartmentHead("test");
        model.setDepartmentName("test");
        model.toString();
        Mockito.when(repo.findAll()).thenReturn(Collections.emptyList());
        service.getAllDepartments();
        Mockito.when(repo.save(Mockito.any())).thenReturn(department);
        service.addDepartment(model);
        Mockito.when(repo.findByDepartmentId(Mockito.anyInt())).thenReturn(department);
        service.getDepartmentById(1);
        Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.of(department));
        service.deleteDepartment(1);
        service.addDepartment(model);
        Object[] data = new Object[]{1,"test", new Date(), "test"};
        List<Object> dataList = new ArrayList<>();
        dataList.add(data);
        Mockito.when(repo.getDepartments(Mockito.anyString())).thenReturn(dataList);
        service.getSearchDepartments("test");

    }

}
