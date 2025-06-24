package com.emp.employees.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.employees.Model.Employee;

import com.emp.employees.Service.EmployeeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    
	@Autowired
	private EmployeeService empserv;
	
    @GetMapping("/all")	
    public List<Employee> getAll(){
    	return empserv.getEmpAll();
    }
    
    @GetMapping("/{id}")
    public Employee getElementById(@PathVariable Long id) {
    	return empserv.getEmpById(id);
    }
    
    @PostMapping("/add")
    public Employee createEmployee(@Valid @RequestBody Employee emp) {
    	return empserv.createEmp(emp);
    	
    }
    
    @PutMapping("/{id}")
    public Employee updateEmp(@PathVariable Long id,Employee emp) {
    	return empserv.updateEmployee(id, emp);
    }
    
    @DeleteMapping("/{id}")
    public String deleteEmp(@PathVariable Long id,Employee emp) {
    	return empserv.deleteEmployeeById(id);
    } 

}
