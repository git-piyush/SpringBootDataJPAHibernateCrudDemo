package com.springboot.demo.modelresponse;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.demo.entity.Employee;

@Component
public class EmployeeModelResponse {
	public String errorDec;
	public List<Employee> employeeList;
	public Employee employee;
	
	public EmployeeModelResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeModelResponse(List<Employee> employeeList, Employee employee) {
		super();
		this.employeeList = employeeList;
		this.employee = employee;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getErrorDec() {
		return errorDec;
	}

	public void setErrorDec(String errorDec) {
		this.errorDec = errorDec;
	}
	
	
}
