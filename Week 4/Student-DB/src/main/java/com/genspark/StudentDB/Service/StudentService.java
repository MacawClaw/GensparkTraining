package com.genspark.StudentDB.Service;

import com.genspark.StudentDB.Entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();


    Student getStudentById(int studentId);

    Student addStudent(Student student);

    Student updateStudent(Student student);

    String deleteStudentById(int studentId);
}
