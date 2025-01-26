package com.emp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dto.DashboardResponse;
import com.emp.dto.DepartmentRequest;
import com.emp.dto.DepartmentResponse;
import com.emp.dto.EmployeeRequest;
import com.emp.dto.ProjectEmpMapRequest;
import com.emp.dto.ProjectEmpResponse;
import com.emp.dto.ProjectRequest;
import com.emp.dto.ProjectResponse;
import com.emp.dto.SubDepartmentResponse;
import com.emp.dto.SubDeptReq;
import com.emp.entity.Department;
import com.emp.entity.Employee;
import com.emp.entity.Project;
import com.emp.entity.ProjectEmpMap;
import com.emp.exceptions.ResourceNotFoundException;
import com.emp.repository.DepartmentRepository;
import com.emp.repository.EmpRepository;
import com.emp.repository.ProjEmpRepository;
import com.emp.repository.ProjectRepository;
import com.emp.repository.SubDepartmentRepository;

@Service
public class EmpProjectMapService {
	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	SubDepartmentRepository subDepartmentRepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	ProjEmpRepository projEmpRepository;

	@Autowired
	ModelMapper modelMapper;

	public Department addDepartment(Department dept) {
		return departmentRepository.save(dept);
	}
	
	public DashboardResponse getDashboard() {
		
		DashboardResponse db=new DashboardResponse();
		db.setTotalEmployee(empRepository.count());
		db.setTotalProject(projectRepository.count());
		
		LocalDate thirtyDaysAgo = LocalDateTime.now().toLocalDate().minusDays(30);
		
		db.setRecentProjects(projectRepository.findProjectsCreatedInLast30Days(thirtyDaysAgo));
		db.setRecentEmployee(empRepository.findEmployeeCreatedInLast30Days(thirtyDaysAgo));
		
		return db;
	}

	public DepartmentResponse getDeptList() {

		List<DepartmentRequest> s1 = departmentRepository.getDeptList();
		DepartmentResponse ss = new DepartmentResponse();
		ss.setData(s1);
		ss.setMessage("testing");
		ss.setResult(true);

		return ss;

	}

	public SubDepartmentResponse getSubDeptByParentId(int id) {
		List<SubDeptReq> s1 = subDepartmentRepository.getSubDeptByParentId(id);
		SubDepartmentResponse ss = new SubDepartmentResponse();
		ss.setData(s1);
		ss.setMessage("testing");
		ss.setResult(true);

		return ss;
	}

	public Optional<Department> getDepById(int id) {
		return departmentRepository.findById(id);
	}

	public Department updateDepartment(int deptId, DepartmentRequest newdept) {
		Optional<Department> existingDept = departmentRepository.findById(deptId);
		if (existingDept.isPresent()) {
			newdept.setDepartmentId(deptId);
			return departmentRepository.save(modelMapper.map(newdept, Department.class));
		} else {
			throw new ResourceNotFoundException("no department exists with this DeptId:" + deptId);
		}
	}

	public Employee addEmployee(Employee employee) {

		if (departmentRepository.findById(employee.getDeptId()).isPresent()) {
			return empRepository.save(employee);
		} else {
			throw new ResourceNotFoundException("no department exists with DeptId:" + employee.getDeptId());
		}
	}

	public List<Employee> getEmpList() {
		return empRepository.findAll();
	}

	public Optional<Employee> getEmpById(int id) {
		return empRepository.findById(id);
	}

	public Employee updateEmp(int empId, EmployeeRequest updateEmp) {
		Optional<Employee> existingEmp = empRepository.findById(empId);
		if (existingEmp.isPresent() && departmentRepository.findById(updateEmp.getDeptId()).isPresent()) {
			updateEmp.setEmployeeId(empId);
			return empRepository.save(modelMapper.map(updateEmp, Employee.class));
		} else {
			throw new ResourceNotFoundException("It could be issue with department id or emp id");
		}
	}

	public Project addProject(Project project) {

		if (empRepository.findById(project.getLeadByEmpId()).isPresent()) {
			return projectRepository.save(project);
		} else {
			throw new ResourceNotFoundException("no employee exist with this emp id:" + project.getLeadByEmpId());
		}
	}

	public List<ProjectResponse> getProjList() {
		//return projectRepository.findAll();
		return projectRepository.getProjList();
	}

	public Optional<Project> getProjById(int id) {
		return projectRepository.findById(id);
	}

	public Project updateProj(int projId, ProjectRequest updateProj) {
		Optional<Project> existingProj = projectRepository.findById(projId);
		if (existingProj.isPresent() && empRepository.findById(updateProj.getLeadByEmpId()).isPresent()) {
			updateProj.setProjectId(projId);
			return projectRepository.save(modelMapper.map(updateProj, Project.class));
		} else {
			throw new ResourceNotFoundException("It could be issue with proj id or emp id");
		}
	}

	public ProjectEmpMap addProjectEmpMap(ProjectEmpMap projectEmpMap) {

		if (empRepository.findById(projectEmpMap.getEmpId()).isPresent()
				&& projectRepository.findById(projectEmpMap.getProjectId()).isPresent()) {
			return projEmpRepository.save(projectEmpMap);
		} else {
			throw new ResourceNotFoundException("It could be issue with proj id or emp id");
		}
	}

	public List<ProjectEmpResponse> getProjectEmpMapList() {
		//return projEmpRepository.findAll();
		return projEmpRepository.getProjEmpList();
	}

	public Optional<ProjectEmpMap> getProjectEmpMapById(int id) {
		return projEmpRepository.findById(id);
	}

	public ProjectEmpMap updateProjectEmpMap(int projId, ProjectEmpMapRequest projEmpMap) {
		Optional<ProjectEmpMap> existingProj = projEmpRepository.findById(projId);
		if (existingProj.isPresent() && empRepository.findById(projEmpMap.getEmpId()).isPresent()
				&& projectRepository.findById(projEmpMap.getProjectId()).isPresent()) {
			projEmpMap.setProjectId(projId);
			return projEmpRepository.save(modelMapper.map(projEmpMap, ProjectEmpMap.class));
		} else {
			throw new ResourceNotFoundException("It could be issue with projemp map id or emp id or proj id");
		}
	}

}
