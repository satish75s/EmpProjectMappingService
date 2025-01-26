package com.emp.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class EmployeeRequest {
	@JsonIgnore
	int employeeId;
	String employeeName;
	String contactNo;
	String emailId;
	int deptId;
	String password;
	String gender;
	String role;
	LocalDate createdDate;
}
