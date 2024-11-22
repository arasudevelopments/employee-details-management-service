package com.employee.details.management.service.controller;


import com.employee.details.management.service.entity.Department;
import com.employee.details.management.service.model.DepartmentModel;
import com.employee.details.management.service.service.DepartmentService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping("/allDepartments")
    public List<DepartmentModel> getAllDepartments(){
        return  service.getAllDepartments();
    }

    @GetMapping("/")
    public DepartmentModel getDepartmentById(@RequestParam int departmentId){
        return  service.getDepartmentById(departmentId);
    }

    @PostMapping("/add")
    public DepartmentModel addDepartment(@RequestBody DepartmentModel department){
        return service.addDepartment(department);
    }

    @PutMapping("/update")
    public DepartmentModel updateDepartment (@RequestBody DepartmentModel department){
        return service.addDepartment(department);
    }

    @DeleteMapping("/delete")
    public boolean deleteDepartment(@RequestParam int id){
        service.deleteDepartment(id);
        return true;
    }

}