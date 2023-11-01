package com.empms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empms.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
