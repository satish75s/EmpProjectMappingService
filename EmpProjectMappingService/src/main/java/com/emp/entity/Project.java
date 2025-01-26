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
public class Project {
	@Id
	@GeneratedValue
	int projectId;
	String projectName;
	String clientName;
	LocalDate startDate;
	int leadByEmpId;
	String contactPerson;
	String contactNo;
	String emailId;

}
