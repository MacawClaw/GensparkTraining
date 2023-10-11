package com.genspark.assingmentfive.Controller;

import com.genspark.assingmentfive.Entity.Employee;
import com.genspark.assingmentfive.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("public")
    public ResponseEntity<String> publicUser(){
        return ResponseEntity.ok("<HTML><H1>I am a public user</H1></HTML>");
    }

    //@MustBeAdmin
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("admin")
    public ResponseEntity<String> adminUser(){
        return ResponseEntity.ok("<HTML><H1>I am an Admin</H1></HTML>");
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("normal")
    public ResponseEntity<String> normalUser(){
        return ResponseEntity.ok("<HTML><H1>I am a Normal User</H1></HTML>");
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(this.employeeService.getAllEmployees());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable String id) {
        return ResponseEntity.ok(this.employeeService.getEmployeeById(Integer.parseInt(id)));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(this.employeeService.addEmployee(employee));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(this.employeeService.updateEmployee(employee));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
        return ResponseEntity.ok(this.employeeService.deleteEmployeeById(Integer.parseInt(id)));
    }
}
