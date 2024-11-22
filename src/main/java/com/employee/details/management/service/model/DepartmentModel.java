package com.employee.details.management.service.model;

import com.employee.details.management.service.entity.Department;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Getter
@Setter
@ToString
public class DepartmentModel {
    private int departmentId;
    private String departmentName;
    private String createdDate;
    private String departmentHead;

    public static Department convertEntity(DepartmentModel model){
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Department department = new Department();
        department.setDepartmentId(model.getDepartmentId());
        department.setDepartmentName(model.getDepartmentName());
        try{
            department.setCreatedDate(format.parse(model.getCreatedDate()));
        }catch (Exception e){
            e.printStackTrace();
        }
        department.setDepartmentHead(model.getDepartmentHead());
        return department;
    }

    public static DepartmentModel convertModel(Department entity){
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        DepartmentModel department = new DepartmentModel();
        department.setDepartmentId(entity.getDepartmentId());
        department.setDepartmentName(entity.getDepartmentName());
        try{
            department.setCreatedDate(format.format(entity.getCreatedDate()));
        }catch (Exception e){
            e.printStackTrace();
        }
        department.setDepartmentHead(entity.getDepartmentHead());
        return department;
    }
}
