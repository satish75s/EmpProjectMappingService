package com.emp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubDeptReq {

	int childDeptId;
    String departmentName;
    int parentDeptId;
}
