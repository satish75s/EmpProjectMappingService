
  package com.emp.repository;
  
  import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import
  org.springframework.stereotype.Repository;

import com.emp.dto.SubDeptReq;
import com.emp.entity.SubDepartment;
  
  @Repository public interface SubDepartmentRepository extends
  JpaRepository<SubDepartment, Integer> {
   @Query(value="SELECT e.parent_dept_id AS parentDeptId, e.department_name AS departmentName, "
   		+ "e.child_dept_id AS childDeptId  from sub_department e where e.parent_dept_id=?1 ",nativeQuery = true)
    public List<SubDeptReq> getSubDeptByParentId(int id);
  }
 