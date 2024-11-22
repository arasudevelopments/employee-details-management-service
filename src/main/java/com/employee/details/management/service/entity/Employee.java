package com.employee.details.management.service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employee_details")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private int age;

    @Column
    private Date dataOfJoining;

    @Column
    private int departmentId;
}
