package com.genspark.employeeservice.Enitity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employees")
@NamedQuery(name="Employee.findByDepartmentId", query = "select e from Employee e where e.departmentId = :departmentId")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String employeeName;

    private long departmentId;

    private Date dob;

}
