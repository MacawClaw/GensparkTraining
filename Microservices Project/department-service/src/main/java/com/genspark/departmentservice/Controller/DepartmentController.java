package com.genspark.departmentservice.Controller;

import com.genspark.departmentservice.Entity.Department;
import com.genspark.departmentservice.Service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments() {return departmentService.getAllDepartments();}

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {return departmentService.getDepartmentById(id);}

    @PostMapping("/")
    public Department createDepartment(@RequestBody Department department) {return departmentService.createDepartment(department);}

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepartment) {return departmentService.updateDepartment(id, updatedDepartment);}

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id) { return departmentService.deleteDepartmentById(id);}
}
