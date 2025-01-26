package com.emp.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProjectEmpMapRequest {
	@JsonIgnore
	int empProjectId;
	int projectId;
	int empId;
	LocalDate assignedDate;
	String role;
	boolean isActive;
}
