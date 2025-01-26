package com.emp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emp.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {
	
	@Query("SELECT p FROM Employee p WHERE p.createdDate >= :sDate")
	List<Employee> findEmployeeCreatedInLast30Days(@Param("sDate") LocalDate startDate);
}
