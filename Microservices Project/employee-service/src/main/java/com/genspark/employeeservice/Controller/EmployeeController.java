package com.genspark.employeeservice.Controller;

import com.genspark.employeeservice.Enitity.Employee;
import com.genspark.employeeservice.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {return employeeService.getAllEmployees();}

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {return employeeService.getEmployeeById(id);}

    @GetMapping("/department/{id}")
    public List<Employee> getEmployeeByDepartmentId(@PathVariable Long id) {return employeeService.getEmployeesByDepartmentId(id);}

    @PostMapping("/")
    public Employee createEmployee(@RequestBody Employee employee) {return employeeService.createEmployee(employee);}

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {return employeeService.updateEmployee(id, updatedEmployee);}

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) { return employeeService.deleteEmployeeById(id);}
}
