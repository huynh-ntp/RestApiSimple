package com.example.restapisimple.controller;

import com.example.restapisimple.entity.Employee;
import com.example.restapisimple.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity getAll(){
       List<Employee> list = employeeService.getAll();
       return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
       Optional<Employee> employee = employeeService.getById(id);
       if(!employee.isPresent()){
           return ResponseEntity.ok("Id not found");
       }
       return ResponseEntity.ok(employee);

    }
    @PostMapping
    public String create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        return employeeService.delete(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id, @RequestBody Employee employee){
        return employeeService.update(id,employee);
    }


}
