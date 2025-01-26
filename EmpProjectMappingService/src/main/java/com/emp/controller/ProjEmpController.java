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

import com.emp.dto.DashboardResponse;
import com.emp.dto.ProjectEmpMapRequest;
import com.emp.dto.ProjectEmpResponse;
import com.emp.entity.ProjectEmpMap;
import com.emp.service.EmpProjectMapService;

@RestController
@RequestMapping("/project-emp-map")
@CrossOrigin
public class ProjEmpController {
	@Autowired
	EmpProjectMapService empProjectMapService;
	
	@GetMapping("/GetDashboard")
	public DashboardResponse getDashboard() {
		return empProjectMapService.getDashboard();
	}
    
	@PostMapping
	public ProjectEmpMap addProjectEmpMap(@RequestBody ProjectEmpMap projectEmpMap) {
		return empProjectMapService.addProjectEmpMap(projectEmpMap);
	}
    
	@GetMapping
	public List<ProjectEmpResponse> getProjectEmpMapList() {
		return empProjectMapService.getProjectEmpMapList();
	}
	
	@GetMapping("/{id}")
	public Optional<ProjectEmpMap> getProjectEmpMapById(@PathVariable int id) {
		return empProjectMapService.getProjectEmpMapById(id);
	}
    
	@PutMapping
	public ProjectEmpMap updateProjectEmpMap(@RequestParam("empProjectId") int projId, @RequestBody ProjectEmpMapRequest projEmpMap) {
		return empProjectMapService.updateProjectEmpMap(projId, projEmpMap);
	}
}
