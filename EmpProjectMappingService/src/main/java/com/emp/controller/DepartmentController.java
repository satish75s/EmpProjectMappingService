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

import com.emp.dto.DepartmentRequest;
import com.emp.dto.DepartmentResponse;
import com.emp.dto.SubDepartmentResponse;
import com.emp.dto.SubDeptReq;
import com.emp.entity.Department;
import com.emp.entity.SubDepartment;
import com.emp.service.EmpProjectMapService;

@RestController
@RequestMapping("/department")
@CrossOrigin
public class DepartmentController {

	@Autowired
	EmpProjectMapService empProjectMapService;
	
	@PostMapping
	public Department addDepartment(@RequestBody Department dept) {
		return empProjectMapService.addDepartment(dept);	
	}
	
	@GetMapping
	public DepartmentResponse getDeptList() {
		return empProjectMapService.getDeptList();	
	}
	
	@GetMapping("/subDeptByParentId/{id}")
	public SubDepartmentResponse getSubDeptByParentId(@PathVariable int id) {
		return empProjectMapService.getSubDeptByParentId(id);	
	}
	
	@GetMapping("/{id}")
	public Optional<Department> getDeptById(@PathVariable int id) {
		return empProjectMapService.getDepById(id);
	}
	
	@PutMapping
	public Department updateDepartment(@RequestParam int deptId,@RequestBody DepartmentRequest newdept) {
		return empProjectMapService.updateDepartment(deptId, newdept);
	}
	
	
}
