package com.app.services;

import java.util.List;


import com.app.dto.DepartmentDTO;
import com.app.dto.DepartmentDocsDTO;
import com.app.entity.Department;


public interface DepartmentService {
	List<Department> getAllDepartmens();
	DepartmentDTO getDepartmentDetails(Long deptId);
	DepartmentDTO addNewDepartment(DepartmentDTO dept);
	DepartmentDocsDTO getDepartmentAndDocDetails(Long deptId);
	
}
