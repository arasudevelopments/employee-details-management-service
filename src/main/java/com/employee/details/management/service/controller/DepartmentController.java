package com.employee.details.management.service.controller;


import com.employee.details.management.service.entity.Department;
import com.employee.details.management.service.model.DepartmentModel;
import com.employee.details.management.service.service.DepartmentService;
import jakarta.annotation.security.RolesAllowed;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping("/allDepartments")
    public List<DepartmentModel> getAllDepartments(){
        return  service.getAllDepartments();
    }

    @GetMapping("/search")
    public List<DepartmentModel> getSearchDepartments(@RequestParam String search){
        return service.getSearchDepartments(search);
    }

    @GetMapping("/")
    public DepartmentModel getDepartmentById(@RequestParam int departmentId){
        return  service.getDepartmentById(departmentId);
    }

    @PostMapping("/add")
    public DepartmentModel addDepartment(@RequestBody DepartmentModel department){
        return service.addDepartment(department);
    }

    @PutMapping("/alterDepartment")
    public DepartmentModel updateDepartment (@RequestBody DepartmentModel department){
        return service.addDepartment(department);
    }

    @DeleteMapping("/removeDepartment")
    public boolean deleteDepartment(@RequestParam int id){
        service.deleteDepartment(id);
        return true;
    }

}
