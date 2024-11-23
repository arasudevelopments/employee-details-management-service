package com.employee.details.management.service.repository;

import com.employee.details.management.service.entity.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DepartmentRepository extends CrudRepository<Department,Integer> {

    Department findByDepartmentId(int id);

    @Query(value="select departmentId,departmentName,createdDate,departmentHead from Department where departmentName like :search")
    List<Object> getDepartments(@Param("search") String search);
}
