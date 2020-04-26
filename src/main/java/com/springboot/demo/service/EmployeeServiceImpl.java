package com.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.dao.EmployeeRepository;
import com.springboot.demo.entity.Employee;
import com.springboot.demo.modelrequest.EmployeeModelRequest;
import com.springboot.demo.modelresponse.EmployeeModelResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("Did not find employee!!");
		}
		return theEmployee;
		
	}

	@Override
	public Employee save(Employee modelRequest) {
		Employee employee = employeeRepository.save(modelRequest);
		return employee;
	}

	@Override
	public EmployeeModelResponse deleteById(int theId) {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		try {
			employeeRepository.deleteById(theId);
			modelResponse.setErrorDec("Requested employee removed");
		} catch (Exception e) {
			System.out.println("Some exception");
			e.printStackTrace();
		}
		return modelResponse;
		
	}

}
