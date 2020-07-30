package com.katorzhin.crud.application.SpringBootCrudApplication.controller;

import com.katorzhin.crud.application.SpringBootCrudApplication.model.Employee;
import com.katorzhin.crud.application.SpringBootCrudApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String findAll(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping("/employee-create")
    public String createUserForm(Employee employee) {
        return "employee-create";
    }

    @PostMapping("/employee-create")
    public String createUser(Employee employee) {
        employeeService.saveUser(employee);
        return "redirect:/employees";
    }

    @GetMapping("employee-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
        return "redirect:/employees";
    }

    @GetMapping("employee-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee-update";
    }
    @PostMapping("/employee-update")
    public String updateUser(Employee employee){
        employeeService.saveUser(employee);
        return "redirect:/employees";
    }
}
