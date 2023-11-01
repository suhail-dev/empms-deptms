package com.empms.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empms.dto.DepartmentDto;
import com.empms.service.DepartmentService;

import lombok.AllArgsConstructor;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("api/departments")
public class DepartmentController {
	
	private DepartmentService departmentService;
	
	//Build create or add department rest API
	@PostMapping
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
		
		DepartmentDto department = departmentService.createDepartment(departmentDto);
		return new ResponseEntity<>(department,HttpStatus.CREATED);
		
	}
	
	//build get Department Rest API
	@GetMapping("{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId){
		 DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
		 return ResponseEntity.ok(departmentDto);
		 
	}
	
	//build get all Departments Rest API
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
		List<DepartmentDto>departments = departmentService.getAllDepartment();
		return ResponseEntity.ok(departments);
	}
	
	//build update Department Rest API
	@PutMapping("{id}")
	public ResponseEntity<DepartmentDto> updatedDepartment(@PathVariable(name = "id") Long departmentId,@RequestBody DepartmentDto updatedDepartment){
	DepartmentDto departmentDto = departmentService.updateDepartment(departmentId, updatedDepartment);
	return ResponseEntity.ok(departmentDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable(name = "id") Long departmentId){
		departmentService.deleteDepartment(departmentId);
		return ResponseEntity.ok("Department Deleted Successfully");
		
	}
}
 