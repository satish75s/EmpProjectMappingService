package com.emp.dto;

import java.util.List;

import com.emp.entity.SubDepartment;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest {
	
	int departmentId;
	String departmentName;
	String departmentLogo;
	@JsonIgnore
	private List<SubDepartment> subDepartments;
	public DepartmentRequest(int departmentId, String departmentName, String departmentLogo) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentLogo = departmentLogo;
	}
	
}
