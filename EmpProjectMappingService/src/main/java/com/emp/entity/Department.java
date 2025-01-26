package com.emp.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {
	@Id
	@GeneratedValue
	int departmentId;
	String departmentName;
	String departmentLogo;
	@OneToMany(targetEntity = SubDepartment.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "parentDeptId", referencedColumnName = "departmentId")
	private List<SubDepartment> subDepartments;

}
