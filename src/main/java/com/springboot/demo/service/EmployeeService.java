package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.entity.Employee;
import com.springboot.demo.modelrequest.EmployeeModelRequest;
import com.springboot.demo.modelresponse.EmployeeModelResponse;

public interface EmployeeService {

    public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public Employee save(Employee modelRequest);
	
	public EmployeeModelResponse deleteById(int theId);

}
