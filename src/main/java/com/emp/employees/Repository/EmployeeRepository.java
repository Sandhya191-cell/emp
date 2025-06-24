package com.emp.employees.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.emp.employees.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

}
