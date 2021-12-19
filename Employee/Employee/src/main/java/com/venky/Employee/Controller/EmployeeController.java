package com.venky.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venky.Employee.Entity.EmployeeEntity;
import com.venky.Employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addEmployee")
	public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return employeeService.saveEmployee(employeeEntity);
	}

	@PostMapping("/addAllEmployees")
	public List<EmployeeEntity> addAllEmployee(@RequestBody List<EmployeeEntity> employeeEntities) {
		return employeeService.saveAllEmployee(employeeEntities);
	}

	@GetMapping("/getEmployee/{id}")
	public EmployeeEntity getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}

	@GetMapping("/getAllEmployess")
	public List<EmployeeEntity> getAllEmployees() {
		return employeeService.getEmployees();

	}

	@GetMapping("/getEmployeeByName/{name}")
	public EmployeeEntity getEmployeeByName(@PathVariable String name) {
		return employeeService.getEmployeeByName(name);
	}

	@DeleteMapping("/deleteEmployeeById/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		return employeeService.deleteById(id);
	}

	@PutMapping("/update")
	public EmployeeEntity updateById(@RequestBody EmployeeEntity employeeEntity) {
		return employeeService.updateEmployee(employeeEntity);

	}
}
