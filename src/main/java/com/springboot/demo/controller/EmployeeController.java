package com.springboot.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.entity.Employee;
import com.springboot.demo.modelrequest.EmployeeModelRequest;
import com.springboot.demo.modelresponse.EmployeeModelResponse;
import com.springboot.demo.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {
		
		private EmployeeService employeeService=null;
		@Autowired
		public EmployeeController(EmployeeService employeeService) {
			super();
			this.employeeService = employeeService;
		}
		// expose "/employees" and return list of employees
		@GetMapping("/getall")
		public EmployeeModelResponse findAll() {
			EmployeeModelResponse modelResponse=new EmployeeModelResponse();
			List<Employee> employeeList = employeeService.findAll();
			modelResponse.setEmployeeList(employeeList);
			return modelResponse;
			
		}
		
		@GetMapping("/getemployeebyid")
		public EmployeeModelResponse findById(@Valid @RequestBody EmployeeModelRequest modelRequest) {
			EmployeeModelResponse modelResponse=new EmployeeModelResponse();
			Employee employee = employeeService.findById(modelRequest.getEmployeeId());
			modelResponse.setEmployee(employee);
			return modelResponse;
		}
		
		@PostMapping("/createemployee")
		public EmployeeModelResponse save(@Valid @RequestBody Employee modelRequest) {
			EmployeeModelResponse modelResponse=new EmployeeModelResponse();
			Employee employee = employeeService.save(modelRequest);
			modelResponse.setEmployee(employee);
			modelResponse.setErrorDec("Below employee added");
			return modelResponse;
		}
		
		@DeleteMapping("/deleteemployee")
		public EmployeeModelResponse delete(@Valid @RequestBody EmployeeModelRequest modelRequest) {
			EmployeeModelResponse modelResponse=new EmployeeModelResponse();
			modelResponse = employeeService.deleteById(modelRequest.getEmployeeId());
			return modelResponse;
		}
		
		
		
		
		
		
		
}
