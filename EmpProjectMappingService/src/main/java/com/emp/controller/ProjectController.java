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

import com.emp.dto.ProjectRequest;
import com.emp.dto.ProjectResponse;
import com.emp.entity.Project;
import com.emp.service.EmpProjectMapService;

@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {
	@Autowired
	EmpProjectMapService empProjectMapService;
	
	@PostMapping
	public Project addProject(@RequestBody Project project) {
		return empProjectMapService.addProject(project);
	}
    
	@GetMapping
	public List<ProjectResponse> getProjList() {
		return empProjectMapService.getProjList();
	}
	
	@GetMapping("/{id}")
	public Optional<Project> getProjById(@PathVariable int id) {
		return empProjectMapService.getProjById(id);
	}
    
	@PutMapping
	public Project updateProj(@RequestParam("projectId") int projId, @RequestBody ProjectRequest updateProj) {
		return empProjectMapService.updateProj(projId, updateProj);
	}
}
