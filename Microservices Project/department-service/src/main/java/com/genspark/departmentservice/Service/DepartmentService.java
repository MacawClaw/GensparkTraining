package com.genspark.departmentservice.Service;

import com.genspark.departmentservice.Entity.Department;
import com.genspark.departmentservice.Repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department updatedDepartment) {
        Department existingDepartment = departmentRepository.findById(id).orElse(null);
        if(existingDepartment != null) {
            existingDepartment.setDepartmentName(updatedDepartment.getDepartmentName());
            existingDepartment.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
            return departmentRepository.save(existingDepartment);
        }
        return null;
    }

    public String deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
        return "The department was deleted successfully";
    }
}
