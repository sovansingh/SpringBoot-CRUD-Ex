package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.entity.Employee;
import com.app.exception.UserNotFoundException;
import com.app.repository.EmployeeRepository;
import com.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		Employee employee = null;
		
		if(optionalEmployee.isPresent()) {
			employee = optionalEmployee.get();
		}else {
			throw new UserNotFoundException("The Employee info is not available: "+employeeId);
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> existingEmployee = employeeRepository.findById(employee.getId());
		if(existingEmployee.isPresent()) {
			existingEmployee.get().setFirstName(employee.getFirstName());
			existingEmployee.get().setLastName(employee.getLastName());
			existingEmployee.get().setEmail(employee.getEmail());
			existingEmployee.get().setDept(employee.getDept());
			existingEmployee.get().setGender(employee.getGender());
			existingEmployee.get().setAge(employee.getAge());
			existingEmployee.get().setJoiningDate(employee.getJoiningDate());
			existingEmployee.get().setRetiringDate(employee.getRetiringDate());
		}else {
			throw new UserNotFoundException("The Employee info is not available: "+employee.getId());
		}
		Employee updateEmployee = employeeRepository.save(existingEmployee.get());
		return updateEmployee;
	}

	@Override
	public void deleteEmployee(Long employeeId) {
//		No class com.app.entity.Employee entity with id 10 exists!"
		employeeRepository.deleteById(employeeId);
	}
	
	
}
