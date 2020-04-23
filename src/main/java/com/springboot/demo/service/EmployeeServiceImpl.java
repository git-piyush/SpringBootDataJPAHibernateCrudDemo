package com.springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.dao.EmployeeDAO;
import com.springboot.demo.entity.Employee;
import com.springboot.demo.modelrequest.EmployeeModelRequest;
import com.springboot.demo.modelresponse.EmployeeModelResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}

	@Override
	public EmployeeModelResponse findAll() {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		modelResponse = employeeDAO.findAll();
		return modelResponse;
	}

	@Override
	public EmployeeModelResponse findById(int theId) {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		modelResponse = employeeDAO.findById(theId);
		return modelResponse;
	}

	@Override
	public EmployeeModelResponse save(EmployeeModelRequest modelRequest) {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		modelResponse = employeeDAO.save(modelRequest);
		return modelResponse;
	}

	@Override
	public EmployeeModelResponse deleteById(int theId) {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		modelResponse = employeeDAO.findById(theId);
		modelResponse = employeeDAO.deleteById(modelResponse.getEmployee());
		return modelResponse;
		
	}

}
