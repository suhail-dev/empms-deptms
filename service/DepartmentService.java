package com.empms.service;

import java.util.List;


import com.empms.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto createDepartment(DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentById(Long departmentId);
	
	List<DepartmentDto> getAllDepartment();
	
	DepartmentDto updateDepartment(Long departmentId, DepartmentDto UpdatedDepartment);
	
	void deleteDepartment(Long departmentId);
}
