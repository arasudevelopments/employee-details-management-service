package com.employee.details.management.service.controller;

import com.employee.details.management.service.model.DepartmentModel;
import com.employee.details.management.service.model.EmployeeModel;
import com.employee.details.management.service.service.EmployeeService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/allEmployees")
    public List<EmployeeModel> getAllEmployees(){
        return  service.getAllEmployees();
    }

    @GetMapping("/getEmployee")
    public EmployeeModel getEmployeeById(@RequestParam int empId){
        return  service.getEmployeeById(empId);
    }

    @GetMapping("/department")
    public List<EmployeeModel> getEmployeeByDepartment(@RequestParam int departmentId){
        return  service.getEmployeeByDepartment(departmentId);
    }

    @GetMapping("/searchEmployee")
    public List<EmployeeModel> getSearchEmployee(@RequestParam String search){
        return service.getSearchEmployee(search);
    }

    @PostMapping("/addEmployee")
    public EmployeeModel addEmployeeDetail(@RequestBody EmployeeModel employee){
        return service.updateEmployee(employee);
    }

    @PutMapping("/alterEmployee")
    public EmployeeModel updateEmployeeDetail(@RequestBody EmployeeModel employee){
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee")
    public boolean deleteEmployeeDetail(@RequestParam int empId){
        service.deleteEmployee(empId);
        return true;
    }
}
