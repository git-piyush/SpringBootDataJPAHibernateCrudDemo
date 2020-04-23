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
		private EmployeeModelResponse modelResponse=null;
		@Autowired
		public EmployeeController(EmployeeService employeeService, EmployeeModelResponse modelResponse) {
			super();
			this.employeeService = employeeService;
			this.modelResponse = modelResponse;
		}
		// expose "/employees" and return list of employees
		@GetMapping("/getall")
		public EmployeeModelResponse findAll() {
			EmployeeModelResponse modelResponse;
			modelResponse = employeeService.findAll();
			return modelResponse;
		}
		
		@GetMapping("/getemployeebyid")
		public EmployeeModelResponse findById(@Valid @RequestBody EmployeeModelRequest modelRequest) {
			modelResponse = employeeService.findById(modelRequest.getEmployeeId());
			return modelResponse;
		}
		
		@PostMapping("/createemployee")
		public EmployeeModelResponse save(@Valid @RequestBody EmployeeModelRequest modelRequest) {
			modelResponse = employeeService.save(modelRequest);
			return modelResponse;
		}
		
		@DeleteMapping("/deleteemployee")
		public EmployeeModelResponse delete(@Valid @RequestBody EmployeeModelRequest modelRequest) {
			modelResponse = employeeService.deleteById(modelRequest.getEmployeeId());
			return modelResponse;
		}
		
		
		
		
		
		
		
}
