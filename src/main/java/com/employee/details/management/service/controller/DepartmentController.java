package com.employee.details.management.service.controller;

import com.employee.details.management.service.model.DepartmentModel;
import com.employee.details.management.service.service.DepartmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {

    Logger logger = LogManager.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService service;

    @GetMapping("/allDepartments")
    public List<DepartmentModel> getAllDepartments(){
        logger.info("getAllDepartments method started..");
        return  service.getAllDepartments();
    }

    @GetMapping("/search")
    public List<DepartmentModel> getSearchDepartments(@RequestParam String search){
        logger.info("getSearchDepartments method started :: {}", search);
        return service.getSearchDepartments(search);
    }

    @GetMapping("/")
    public DepartmentModel getDepartmentById(@RequestParam int departmentId){
        logger.info("getDepartmentById method started :: {}", departmentId);
        return  service.getDepartmentById(departmentId);
    }

    @PostMapping("/add")
    public DepartmentModel addDepartment(@RequestBody DepartmentModel department){
        logger.info("addDepartment method started :: {}", department);
        return service.addDepartment(department);
    }

    @PutMapping("/alterDepartment")
    public DepartmentModel updateDepartment (@RequestBody DepartmentModel department){
        logger.info("updateDepartment method started :: {}", department);
        return service.addDepartment(department);
    }

    @DeleteMapping("/removeDepartment")
    public boolean deleteDepartment(@RequestParam int id){
        logger.info("deleteDepartment method started :: {}", id);
        service.deleteDepartment(id);
        return true;
    }

}
