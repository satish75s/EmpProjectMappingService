package com.emp.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubDepartmentResponse{
    public String message;
    public boolean result;
    public List<SubDeptReq> data;
}
