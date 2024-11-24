package com.employee.details.management.service.service;


import com.employee.details.management.service.entity.Department;
import com.employee.details.management.service.model.DepartmentModel;
import com.employee.details.management.service.repository.DepartmentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    Logger logger = LogManager.getLogger(DepartmentService.class);

    public List<DepartmentModel> getAllDepartments(){
        logger.info("getAllDepartments method started..");
        return StreamSupport
                .stream(repo.findAll().spliterator(), false)
                .map(data-> DepartmentModel.convertModel(data))
                .collect(Collectors.toList());
    }


    public DepartmentModel getDepartmentById(int id){
        logger.info("getDepartmentById method started..");
        Department entity = repo.findByDepartmentId(id);
        logger.info("getDepartmentById method response :: {}", entity);
        return DepartmentModel.convertModel(entity);
    }

    public void deleteDepartment(int id){
        logger.info("deleteDepartment method started..");
        repo.delete(repo.findById(id).get());
    }

    public DepartmentModel addDepartment(DepartmentModel department){
        logger.info("addDepartment method started..");
        Department department1 = repo.save(DepartmentModel.convertEntity(department));
        logger.info("addDepartment method response :: {}", department1);
        return DepartmentModel.convertModel(department1);
    }

    public List<DepartmentModel> getSearchDepartments(String search) {
        logger.info("getSearchDepartments method started..");
        List<Object> dataList = repo.getDepartments("%"+search+"%");
        logger.info("getSearchDepartments method response :: {}", dataList);
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
