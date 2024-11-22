package com.employee.details.management.service.model;

import com.employee.details.management.service.entity.Employee;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.text.SimpleDateFormat;

@Getter
@Setter
@ToString
public class EmployeeModel {
    private int employeeId;
    private String name;
    private String email;
    private int age;
    private String dataOfJoining;
    private int departmentId;

    public static Employee convertEntity(EmployeeModel model){
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Employee employee = new Employee();
        employee.setEmployeeId(model.getEmployeeId());
        employee.setEmail(model.getEmail());
        employee.setName(model.getName());
        employee.setAge(model.getAge());
        try{
            employee.setDataOfJoining(format.parse(model.getDataOfJoining()));
        }catch (Exception e){
            e.printStackTrace();
        }
        employee.setDepartmentId(model.getDepartmentId());
        return employee;
    }

    public static EmployeeModel convertModel(Employee entity){
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        EmployeeModel employee = new EmployeeModel();
        employee.setEmployeeId(entity.getEmployeeId());
        employee.setEmail(entity.getEmail());
        employee.setName(entity.getName());
        employee.setAge(entity.getAge());
        try{
            employee.setDataOfJoining(format.format(entity.getDataOfJoining()));
        }catch (Exception e){
            e.printStackTrace();
        }
        employee.setDepartmentId(entity.getDepartmentId());
        return employee;
    }
}
