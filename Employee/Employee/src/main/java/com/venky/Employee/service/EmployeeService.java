package com.venky.Employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venky.Employee.Entity.EmployeeEntity;
import com.venky.Employee.Repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	public EmployeeRepo repository;

	public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
		return repository.save(employeeEntity);
	}

	public List<EmployeeEntity> saveAllEmployee(List<EmployeeEntity> empEntity) {
		return repository.saveAll(empEntity);
	}

	public List<EmployeeEntity> getEmployees() {
		return repository.findAll();
	}

	public EmployeeEntity getEmployeeById(int id) {
		return repository.findById(id).orElse(null);
	}

	public EmployeeEntity getEmployeeByName(String name) {
		return repository.findByName(name);
	}

	public String deleteById(int id) {
		repository.deleteById(id);
		return "Employee " + id + " has deleted successfully";
	}

	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
		EmployeeEntity exestingRecord = repository.findById(employeeEntity.getId()).orElse(null);
		exestingRecord.setName(employeeEntity.getName());
		exestingRecord.setMailId(exestingRecord.getMailId());
		exestingRecord.setDept(exestingRecord.getDept());
		exestingRecord.setDateOfBirth(employeeEntity.getDateOfBirth());
		exestingRecord.setAddress(employeeEntity.getAddress());
		exestingRecord.setSalary(employeeEntity.getSalary());

		return repository.save(exestingRecord);

	}

}
