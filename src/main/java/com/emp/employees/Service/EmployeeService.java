package com.emp.employees.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.employees.Model.Employee;
import com.emp.employees.Repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository emprepo;
	
	public List<Employee> getEmpAll()      //Get All Employees
	{
		return emprepo.findAll();
	} 
	
	public Employee getEmpById(Long id)    //Get Single Employee By Id
	{
	 return emprepo.findById(id).orElse(null);
	}

	public Employee createEmp(Employee emp)  
	{
		try {
			return emprepo.save(emp);
		}
		catch(Exception e) {
			throw new RuntimeException("Email is already existed");
			
		}
	}
	
	public Employee updateEmployee(Long id, Employee updateEmployee) {  //update employee By ID
		Employee emp =emprepo.findById(id) .orElse(null);
		if(emp!=null) {
			
			emp.setName(updateEmployee.getName());
			emp.setEmail(updateEmployee.getEmail());
			emp.setDepartment(updateEmployee.getDepartment());
			try {
				return emprepo.save(emp);
			}
			catch(Exception e) {
				throw new RuntimeException("Email is already  existed");
				
			}

		}
		return emp;
	}
    
	public String deleteEmployeeById(Long id) {  //delete employee by id
		if(emprepo.existsById(id)) {
			emprepo.deleteById(id);
			return "Employee deleted successfully with id :" +id;
		}
		else {
			return "Employee Not found with id:"+id;
		}
		
	}
}
