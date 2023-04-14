package com.genspark.StudentDB.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @Column(name = "s_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    @NonNull
    private String fullName;

    @NonNull
    private String phone;

    @NonNull
    private String address;
}