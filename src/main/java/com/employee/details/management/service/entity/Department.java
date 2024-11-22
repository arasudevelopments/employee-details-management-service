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
@Table(name = "department_details")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int departmentId;

    @Column
    private String departmentName;

    @Column
    private Date createdDate;

    @Column
    private String departmentHead;

}
