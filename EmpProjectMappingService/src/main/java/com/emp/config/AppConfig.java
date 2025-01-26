package com.emp.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.emp.dto.DepartmentRequest;
import com.emp.entity.Department;

@Configuration
public class AppConfig {
	@Bean
	public ModelMapper modelMapper() {

	ModelMapper modelMapper = new ModelMapper();	
		
	TypeMap<Department, DepartmentRequest> typeMap = modelMapper.createTypeMap(Department.class, DepartmentRequest.class);	
	typeMap.addMappings(mapper -> {
				//Custom mapping if property names or types are different
				//mapper.map(User::getEname, UserDTO::setEmpName);	
	//mapper.map(User::getFirstName, UserDTO::setName);	
			});
	return modelMapper;
		}

}
