package com.emp.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProjectRequest {
	@JsonIgnore
	int projectId;
	String projectName;
	String clientName;
	LocalDate startDate;
	int leadByEmpId;
	String contactPerson;
	String contactNo;
	String emailId;
}
