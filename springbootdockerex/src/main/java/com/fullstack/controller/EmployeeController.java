package com.fullstack.controller;

import com.fullstack.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    List<Employee> employeeList = Stream.of(new Employee(121, "SWARA", 97000),
            new Employee(122, "DARSHAN", 91000),
            new Employee(123, "LAKSHMI", 96000)).toList();

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeList);
    }
    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByName(){
        return ResponseEntity.ok(employeeList.stream().sorted(Comparator.comparing(Employee::getEmpName)).toList());
    }

}
