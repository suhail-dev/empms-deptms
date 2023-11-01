package com.empms.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.empms.Entity.Department;
import com.empms.dto.DepartmentDto;
import com.empms.exception.ResourceNotFoundException;
import com.empms.mapper.DepartmentMapper;
import com.empms.repository.DepartmentRepository;
import com.empms.service.DepartmentService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;
	
	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		// TODO Auto-generated method stub
		Department department=DepartmentMapper.mapToDepartment(departmentDto);
		Department savedDepartment = departmentRepository.save(department);
		return DepartmentMapper.mapToDepartmentDto(savedDepartment);
	}

	@Override
	public DepartmentDto getDepartmentById(Long departmentId) {

		Department department =  departmentRepository.findById(departmentId).orElseThrow(
				() ->new ResourceNotFoundException("Department is not exist with a given Id "+ departmentId)
				);
		return DepartmentMapper.mapToDepartmentDto(department);
	}

	@Override
	public List<DepartmentDto> getAllDepartment() {
		List<Department> departments = departmentRepository.findAll();
		
		return departments.stream().map((department)->DepartmentMapper.mapToDepartmentDto(department))
				.collect(Collectors.toList());
	}

	@Override
	public DepartmentDto updateDepartment(Long departmentId, DepartmentDto UpdatedDepartment) {
		// TODO Auto-generated method stub
		Department department = departmentRepository.findById(departmentId).orElseThrow(
				()-> new ResourceNotFoundException("Department is not exist with a given id" +departmentId)
				);
		department.setDepartmentName(UpdatedDepartment.getDepartmentName());
		department.setDepartmentDescription(UpdatedDepartment.getDepartmentDescription());
		
		Department savedDepartment =  departmentRepository.save(department);
		return DepartmentMapper.mapToDepartmentDto(savedDepartment);
	}

	@Override
	public void deleteDepartment(Long departmentId) {
		// TODO Auto-generated method stub
		departmentRepository.findById(departmentId).orElseThrow(
			()-> new ResourceNotFoundException("Department is not exist with a given id" +departmentId)
		);
		
		departmentRepository.deleteById(departmentId);
		
	}

	
}
