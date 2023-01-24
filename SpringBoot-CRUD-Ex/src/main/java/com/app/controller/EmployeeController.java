package com.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/employees")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	@ApiOperation(value = "Add a Employee")
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		Employee saveEmployee = employeeService.createEmployee(employee);
		return new ResponseEntity<>(saveEmployee,HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Search a Employee with an ID",response = Employee.class)
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId){
		Employee employee = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@ApiOperation(value = "View a list of available Employees",response = Iterable.class)
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update an Employee")
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,
													@RequestBody Employee employee){
		employee.setId(employeeId);
		Employee updatedEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete an Employee")
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<>("Employee successfully deleted!",HttpStatus.OK);
	}
}
