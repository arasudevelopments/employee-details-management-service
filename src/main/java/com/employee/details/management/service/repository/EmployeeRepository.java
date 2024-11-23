package com.employee.details.management.service.repository;

import com.employee.details.management.service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee findByEmployeeId(int employeeId);

    List<Employee> findByDepartmentId(int departmentId);

    @Query(value="select employeeId,name,email,age,dataOfJoining,departmentId from Employee where name like :search")
    List<Object> getSearchEmployee(@Param("search") String search);
}
