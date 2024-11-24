package com.employee.details.management.service.controller;


import com.employee.details.management.service.model.DepartmentModel;
import com.employee.details.management.service.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;


@RunWith(MockitoJUnitRunner.class)
public class DepartmentControllerTest {

    @InjectMocks
    DepartmentController controller;

    @Mock
    DepartmentService service;

    @Test
    public void test1(){
        Mockito.when(service.getAllDepartments()).thenReturn(Collections.emptyList());
        Mockito.when(service.getDepartmentById(Mockito.anyInt())).thenReturn(new DepartmentModel());
        controller.getAllDepartments();
        controller.getDepartmentById(1);
        Mockito.when(service.addDepartment(Mockito.any())).thenReturn(new DepartmentModel());
        controller.addDepartment(new DepartmentModel());
        controller.updateDepartment(new DepartmentModel());
        controller.deleteDepartment(1);
        Mockito.when(service.getSearchDepartments(Mockito.anyString())).thenReturn(Collections.emptyList());
        controller.getSearchDepartments("test");
    }
}
