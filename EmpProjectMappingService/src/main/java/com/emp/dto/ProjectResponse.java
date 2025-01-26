package com.emp.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProjectResponse {
	int projectId;
	String projectName;
	String clientName;
	LocalDate startDate;
	int leadByEmpId;
	String contactPerson;
	String contactNo;
	String emailId;
	String employeeName;
}
