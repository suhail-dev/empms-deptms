package com.empms.mapper;

import com.empms.Entity.Department;
import com.empms.dto.DepartmentDto;

public class DepartmentMapper {
	
	//convert department jpa entity into department dto
	
	public static DepartmentDto mapToDepartmentDto(Department department) {
		return new DepartmentDto(
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDescription()
				);
	}
	
	//convert department dto  into department jpa entity
	
	public static Department mapToDepartment(DepartmentDto departmentDto) {
		return new Department(
				departmentDto.getId(),
				departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription()
				);
		
	}

}
