package com.employee.details.management.service.service;


import com.employee.details.management.service.entity.Employee;
import com.employee.details.management.service.model.EmployeeModel;
import com.employee.details.management.service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<EmployeeModel> getAllEmployees(){
        return StreamSupport.stream(repo.findAll().spliterator(), false).map(data->EmployeeModel.convertModel(data)).toList();
    }

    public List<EmployeeModel> getEmployeeByDepartment(int departmentId){
        return StreamSupport.stream(repo.findByDepartmentId(departmentId).spliterator(), false).map(data->EmployeeModel.convertModel(data)).toList();
    }

    public EmployeeModel getEmployeeById(int id){
        Employee entity = repo.findByEmployeeId(id);
        return EmployeeModel.convertModel(entity);
    }

    public void deleteEmployee(int id){
        repo.delete(repo.findByEmployeeId(id));
    }

    public EmployeeModel updateEmployee(EmployeeModel employee){
        Employee entity = repo.save(EmployeeModel.convertEntity(employee));
        return EmployeeModel.convertModel(entity);
    }

}
