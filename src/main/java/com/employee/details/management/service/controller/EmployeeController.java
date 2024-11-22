package com.employee.details.management.service.controller;

import com.employee.details.management.service.entity.Department;
import com.employee.details.management.service.entity.Employee;
import com.employee.details.management.service.model.EmployeeModel;
import com.employee.details.management.service.service.DepartmentService;
import com.employee.details.management.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/employee")
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

    @PostMapping("/addEmployee")
    public EmployeeModel addEmployee(@RequestBody EmployeeModel employee){
        return service.updateEmployee(employee);
    }

    @PutMapping("/updateEmployee")
    public EmployeeModel updateEmployee (@RequestBody EmployeeModel employee){
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee")
    public boolean deleteEmployee(@RequestParam int empId){
        service.deleteEmployee(empId);
        return true;
    }
}
