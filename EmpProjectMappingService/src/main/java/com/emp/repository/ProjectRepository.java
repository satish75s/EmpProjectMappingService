package com.emp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emp.dto.ProjectResponse;
import com.emp.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	
	@Query(value="select new com.emp.dto.ProjectResponse(a.projectId,a.projectName,a.clientName,a.startDate,a.leadByEmpId,a.contactPerson,a.contactNo,a.emailId,b.employeeName) from Project a, Employee b where a.leadByEmpId=b.employeeId")
    public List<ProjectResponse> getProjList();
	
	
	@Query("SELECT p FROM Project p WHERE p.startDate >= :sDate")
	List<Project> findProjectsCreatedInLast30Days(@Param("sDate") LocalDate startDate);
	

}
