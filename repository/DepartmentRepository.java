package com.empms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empms.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	

}
