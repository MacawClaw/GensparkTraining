package com.genspark.employeeservice.Service;

import com.genspark.employeeservice.Enitity.Employee;
import com.genspark.employeeservice.Repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private final EntityManager entityManager;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getEmployeesByDepartmentId(Long departmentId) {
        //return employeeRepository.findByDepartmentId(id);
        TypedQuery<Employee> typedQuery = entityManager.createNamedQuery("Employee.findByDepartmentId", Employee.class);
        typedQuery.setParameter("departmentId", departmentId);

        return  typedQuery.getResultList();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if(existingEmployee != null) {
            existingEmployee.setEmployeeName(updatedEmployee.getEmployeeName());
            existingEmployee.setDepartmentId(updatedEmployee.getDepartmentId());
            existingEmployee.setDob(updatedEmployee.getDob());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    public String deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
        return "The employee was deleted successfully";
    }
}
