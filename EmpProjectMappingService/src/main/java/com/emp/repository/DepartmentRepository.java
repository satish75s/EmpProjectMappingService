package com.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emp.dto.DepartmentRequest;
import com.emp.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
   
	
	@Query(value="SELECT e.department_id AS departmentId, e.department_logo AS departmentLogo, e.department_name AS departmentName  from department e",nativeQuery = true)
	    public List<DepartmentRequest> getDeptList();
}
