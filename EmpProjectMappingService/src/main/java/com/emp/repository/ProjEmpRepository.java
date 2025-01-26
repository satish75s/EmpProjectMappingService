package com.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emp.dto.ProjectEmpResponse;
import com.emp.entity.ProjectEmpMap;

@Repository
public interface ProjEmpRepository extends JpaRepository<ProjectEmpMap, Integer> {

	@Query(value="select new com.emp.dto.ProjectEmpResponse(a.empProjectId,a.projectId,a.empId,a.assignedDate,a.role,a.isActive,b.projectName,c.employeeName) from ProjectEmpMap a, Project b, Employee c where a.projectId=b.projectId and a.empId=c.employeeId")
    public List<ProjectEmpResponse> getProjEmpList();
	
	
	
	
	
	
	
	
}
