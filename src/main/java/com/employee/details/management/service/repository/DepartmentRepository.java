package com.employee.details.management.service.repository;

import com.employee.details.management.service.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends CrudRepository<Department,Integer> {

    Department findByDepartmentId(int id);
}
