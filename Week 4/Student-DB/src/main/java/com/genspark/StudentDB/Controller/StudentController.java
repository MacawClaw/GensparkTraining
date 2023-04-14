package com.genspark.StudentDB.Controller;

import com.genspark.StudentDB.Entity.Student;
import com.genspark.StudentDB.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home(){
        return "<HTML><H1>Welcome to the Student Application</H1></HTML>";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.studentService.getAllStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable String studentId) {
        return this.studentService.getStudentById(Integer.parseInt(studentId));
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return this.studentService.updateStudent(student);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable String studentId) {
        return this.studentService.deleteStudentById(Integer.parseInt(studentId));
    }
}
