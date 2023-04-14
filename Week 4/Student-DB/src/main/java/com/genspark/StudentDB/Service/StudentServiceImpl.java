package com.genspark.StudentDB.Service;

import com.genspark.StudentDB.Dao.StudentDao;
import com.genspark.StudentDB.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getAllStudents(){
        return this.studentDao.findAll();
    }

    @Override
    public Student getStudentById(int studentId){
        Optional <Student> s = this.studentDao.findById(studentId);
        Student student = null;
        if(s.isPresent()) {
            student = s.get();
        } else {
            throw new RuntimeException("Student not found for id :: " + studentId);
        }

        return student;
    }

    @Override
    public Student addStudent(Student student){
        return this.studentDao.save(student);
    }

    @Override
    public Student updateStudent(Student student){
        return this.studentDao.save(student);

    }

    @Override
    public String deleteStudentById(int studentId){
        this.studentDao.deleteById(studentId);
        return "Deleted Successfully";
    }

}
