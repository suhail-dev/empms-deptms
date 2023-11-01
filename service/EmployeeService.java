package com.empms.service;

import java.util.List;

import com.empms.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmoloyeeById(Long employeeId);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto UpdatedEmployee);
	
	void deleteEmployee(Long employeeId);
		
		
	

}
