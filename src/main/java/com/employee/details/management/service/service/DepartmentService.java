package com.employee.details.management.service.service;


import com.employee.details.management.service.entity.Department;
import com.employee.details.management.service.model.DepartmentModel;
import com.employee.details.management.service.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repo;

    public List<DepartmentModel> getAllDepartments(){
        return StreamSupport
                .stream(repo.findAll().spliterator(), false)
                .map(data-> DepartmentModel.convertModel(data))
                .collect(Collectors.toList());
    }


    public DepartmentModel getDepartmentById(int id){
        Department entity = repo.findByDepartmentId(id);
        return DepartmentModel.convertModel(entity);
    }

    public void deleteDepartment(int id){
         repo.delete(repo.findById(id).get());
    }

    public DepartmentModel addDepartment(DepartmentModel department){
        Department department1 = repo.save(DepartmentModel.convertEntity(department));
        return DepartmentModel.convertModel(department1);
    }

    public List<DepartmentModel> getSearchDepartments(String search) {
        List<Object> dataList = repo.getDepartments("%"+search+"%");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return dataList.stream().map(data->{
                    Object[] detail = (Object[]) data;
                    DepartmentModel department = new DepartmentModel();
                    department.setDepartmentName((String) detail[1]);
                    department.setDepartmentId((Integer) detail[0]);
                    department.setCreatedDate(format.format((Date) detail[2]));
                    department.setDepartmentHead((String)detail[3]);
                    return department;
                }).toList();
    }
}
