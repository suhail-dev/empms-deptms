package com.empms.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.empms.Entity.Department;
import com.empms.Entity.Employee;
import com.empms.dto.EmployeeDto;
import com.empms.exception.ResourceNotFoundException;
import com.empms.mapper.EmployeeMapper;
import com.empms.repository.DepartmentRepository;
import com.empms.repository.EmployeeRepository;
import com.empms.service.EmployeeService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmoloyeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	private DepartmentRepository departmentRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee= EmployeeMapper.mapsToEmployee(employeeDto);
		
		Department department =  departmentRepository.findById(employeeDto.getDepartmentId()).
				orElseThrow(()->
		new ResourceNotFoundException("Department is not exist with given id: " + employeeDto.getDepartmentId()));
		
		employee.setDepartment(department);
		
		Employee savedEmployee=employeeRepository.save(employee);
		return EmployeeMapper.mapsToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmoloyeeById(Long employeeId) {
		Employee employee =  employeeRepository.findById(employeeId).
				orElseThrow(() ->
				new ResourceNotFoundException("Employee not exist with given id: " +employeeId));
		return EmployeeMapper.mapsToEmployeeDto(employee);

	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees= employeeRepository.findAll();
		return employees.stream().map((employee) ->EmployeeMapper.mapsToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee = employeeRepository.findById(employeeId).
				orElseThrow(() ->
				new ResourceNotFoundException("Employee not exist with given id: " +employeeId));

		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		
		Department department =  departmentRepository.findById(updatedEmployee.getDepartmentId()).
				orElseThrow(()->
		new ResourceNotFoundException("Department is not exist with given id: " + updatedEmployee.getDepartmentId()));
		
		employee.setDepartment(department);
		
		Employee updatedEmployeeObj = employeeRepository.save(employee);
		return EmployeeMapper.mapsToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public  void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() ->
				new ResourceNotFoundException("Employee not exist with given id: " +employeeId));
		employeeRepository.deleteById(employeeId);
//		Employee deletedEmployeeObj = employeeRepository.deleteById(employeeId);
//		return EmployeeMapper.mapsToEmployeeDto(deletedEmployeeObj);
	}



}
