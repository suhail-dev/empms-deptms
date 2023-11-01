package com.empms.mapper;

import com.empms.Entity.Employee;
import com.empms.dto.EmployeeDto;

public class EmployeeMapper {
	public static EmployeeDto mapsToEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartment().getId()
				);
	}
	
	public static Employee mapsToEmployee(EmployeeDto employeeDto) {
		Employee employee= new Employee();
		employee.setId(employeeDto.getId());
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		
		return employee;
	}

}

