package com.genspark.employeeservice.Repository;

import com.genspark.employeeservice.Enitity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> findByDepartmentId(Long departmentId);

}
