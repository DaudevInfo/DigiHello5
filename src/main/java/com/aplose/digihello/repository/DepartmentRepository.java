package com.aplose.digihello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aplose.digihello.model.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long> {
	public Department findByCode(String code);
	public void deleteByCode(String code);
}
