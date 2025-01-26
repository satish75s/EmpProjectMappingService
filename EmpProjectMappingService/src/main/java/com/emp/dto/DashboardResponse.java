package com.emp.dto;


import java.util.List;

import com.emp.entity.Employee;
import com.emp.entity.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class DashboardResponse {

    public long totalEmployee;
    public long totalProject;
    public List<Project> recentProjects;
    public List<Employee> recentEmployee;
}

