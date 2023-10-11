package com.genspark.assingmentfive.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    //Universal Product Number used as Id
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    private String employeeName;

    @NonNull
    private int departmentId;

    @NonNull
    private Date dob;
}
