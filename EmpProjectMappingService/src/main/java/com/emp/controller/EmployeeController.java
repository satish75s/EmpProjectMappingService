package com.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp.dto.EmployeeRequest;
import com.emp.entity.Employee;
import com.emp.service.EmpProjectMapService;

@RestController
@RequestMapping("/emp")
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	EmpProjectMapService empProjectMapService;
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		return empProjectMapService.addEmployee(employee);
	}

	@GetMapping
	public List<Employee> getEmpList() {
		return empProjectMapService.getEmpList();
	}
	
	@GetMapping("/{id}")
	public Optional<Employee> getEmpbyId(@PathVariable int id) {
		return empProjectMapService.getEmpById(id);
	}
    
	@PutMapping
	public Employee updateEmp(@RequestParam("empId") int empId, @RequestBody EmployeeRequest updateEmp) {
		return empProjectMapService.updateEmp(empId, updateEmp);
	}

	

}
