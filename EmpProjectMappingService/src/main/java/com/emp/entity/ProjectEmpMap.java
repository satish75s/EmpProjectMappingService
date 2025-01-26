package com.emp.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class ProjectEmpMap {
	@Id
	@GeneratedValue
	int empProjectId;
	int projectId;
	int empId;
	LocalDate assignedDate;
	String role;
	boolean isActive;

}
