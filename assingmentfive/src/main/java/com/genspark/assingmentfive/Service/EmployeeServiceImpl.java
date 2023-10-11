package com.genspark.assingmentfive.Service;

import com.genspark.assingmentfive.Dao.EmployeeDao;
import com.genspark.assingmentfive.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees(){
        return this.employeeDao.findAll();
    }

    //UPC used as Id, findById method given by dependencies within findbyUpc
    @Override
    public Employee getEmployeeById(int id){
        Optional <Employee> e = this.employeeDao.findById(id);
        Employee employee = null;
        if(e.isPresent()) {
            employee = e.get();
        } else {
            throw new RuntimeException("Product not found for upc :: " + id);
        }

        return employee;
    }

    @Override
    public Employee addEmployee(Employee employee){
        return this.employeeDao.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee){
        return this.employeeDao.save(employee);

    }

    @Override
    public String deleteEmployeeById(int id){
        this.employeeDao.deleteById(id);
        return "Deleted Successfully";
    }

}
