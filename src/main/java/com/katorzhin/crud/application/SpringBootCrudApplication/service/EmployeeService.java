package com.katorzhin.crud.application.SpringBootCrudApplication.service;

import com.katorzhin.crud.application.SpringBootCrudApplication.model.Employee;
import com.katorzhin.crud.application.SpringBootCrudApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee saveUser(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
