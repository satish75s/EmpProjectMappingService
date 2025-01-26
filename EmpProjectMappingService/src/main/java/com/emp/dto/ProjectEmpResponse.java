package com.emp.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProjectEmpResponse {
	int empProjectId;
	int projectId;
	int empId;
	LocalDate assignedDate;
	String role;
	boolean isActive;
	String projectName;
	String employeeName;

}
