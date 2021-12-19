package com.venky.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venky.Employee.Entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

	EmployeeEntity findByName(String name);

}
