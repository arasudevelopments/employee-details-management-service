package com.employee.details.management.service.service;


import com.employee.details.management.service.entity.Employee;
import com.employee.details.management.service.model.DepartmentModel;
import com.employee.details.management.service.model.EmployeeModel;
import com.employee.details.management.service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    public List<EmployeeModel> getSearchEmployee(String search) {
        List<Object> dataList = repo.getSearchEmployee("%"+search+"%");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return dataList.stream().map(data->{
            Object[] detail = (Object[]) data;
            EmployeeModel employeeModel = new EmployeeModel();
            employeeModel.setEmployeeId((Integer) detail[0]);
            employeeModel.setName((String) detail[1]);
            employeeModel.setEmail((String) detail[2]);
            employeeModel.setAge((Integer)detail[3]);
            employeeModel.setDateOfJoining(format.format((Date)detail[4]));
            employeeModel.setDepartmentId((Integer) detail[5]);
            return employeeModel;
        }).toList();
    }
}
