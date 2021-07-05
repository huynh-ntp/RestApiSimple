package com.example.restapisimple.service;

import com.example.restapisimple.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAll();
    String create(Employee employee);
    String delete(Long id);
    String update(Long id, Employee employee);
    Optional<Employee> getById(Long id);
}
