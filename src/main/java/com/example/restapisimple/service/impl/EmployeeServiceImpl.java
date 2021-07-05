package com.example.restapisimple.service.impl;

import com.example.restapisimple.entity.Employee;
import com.example.restapisimple.repository.EmployeeRepository;
import com.example.restapisimple.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepo;


    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @Override
    public String create(Employee employee) {
        employeeRepo.save(employee);
        return "Insert success";
    }

    @Override
    public String delete(Long id) {
        if(employeeRepo.existsById(id)){
            employeeRepo.deleteById(id);
            return "Delete success";
        }
        return "Id not found";
    }

    @Override
    public String update(Long id, Employee employee) {
        if(employeeRepo.existsById(id)){
            employee.setId(id);
            employeeRepo.save(employee);
            return "Update success";
        }
        return "Id not found";
    }

    @Override
    public Optional<Employee> getById(Long id) {
        return employeeRepo.findById(id);
    }
}
