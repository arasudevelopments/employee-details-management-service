package com.employee.details.management.service.controller;

import com.employee.details.management.service.model.DepartmentModel;
import com.employee.details.management.service.model.EmployeeModel;
import com.employee.details.management.service.service.EmployeeService;
import jakarta.annotation.security.RolesAllowed;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    Logger logger = LogManager.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService service;

    @GetMapping("/allEmployees")
    public List<EmployeeModel> getAllEmployees(){
        logger.info("getAllEmployees method startd..");
        return  service.getAllEmployees();
    }

    @GetMapping("/getEmployee")
    public EmployeeModel getEmployeeById(@RequestParam int empId){
        logger.info("getEmployeeById method startd :: {}", empId);
        return  service.getEmployeeById(empId);
    }

    @GetMapping("/department")
    public List<EmployeeModel> getEmployeeByDepartment(@RequestParam int departmentId){
        logger.info("getEmployeeByDepartment method startd :: {}", departmentId);
        return  service.getEmployeeByDepartment(departmentId);
    }

    @GetMapping("/searchEmployee")
    public List<EmployeeModel> getSearchEmployee(@RequestParam String search){
        logger.info("getSearchEmployee method startd :: {}", search);
        return service.getSearchEmployee(search);
    }

    @PostMapping("/addEmployee")
    public EmployeeModel addEmployeeDetail(@RequestBody EmployeeModel employee){
        logger.info("addEmployeeDetail method startd :: {}", employee);
        return service.updateEmployee(employee);
    }

    @PutMapping("/alterEmployee")
    public EmployeeModel updateEmployeeDetail(@RequestBody EmployeeModel employee){
        logger.info("updateEmployeeDetail method startd :: {}", employee);
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee")
    public boolean deleteEmployeeDetail(@RequestParam int empId){
        logger.info("deleteEmployeeDetail method startd :: {}", empId);
        service.deleteEmployee(empId);
        return true;
    }
}
