package org.restserviceapplicationrabo.restcontroller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.restserviceapplicationrabo.exception.ResourceNotFoundException;
import org.restserviceapplicationrabo.model.Employee;

import org.restserviceapplicationrabo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="v2",produces= {MediaType.APPLICATION_JSON_VALUE})
public class EmployeeController {
@Autowired

private EmployeeRepository emprepository;

//get all employees
@GetMapping("/employees")
@ResponseStatus(HttpStatus.OK)
public List<Employee> getAllEmployees()
{
	return emprepository.findAll();
}

//Create employees
@PostMapping("/employees")
@ResponseStatus(HttpStatus.CREATED)
public Employee createEmployee(@RequestBody Employee employee)
{
	
	return emprepository.save(employee);
	//return new Messagehandler("200", "employee created successfully");
}

//Create employees
@PostMapping("/employees/createWithArray")
@ResponseStatus(HttpStatus.CREATED)
public List<Employee> ListofEmployee(@RequestBody List<Employee> employees)
{
	
	return emprepository.saveAll(employees);
	
	//return new Messagehandler("200", "employee created successfully");
}

// get employee by id
@GetMapping("/employees/{id}")
@ResponseStatus(HttpStatus.FOUND)
public ResponseEntity<Employee> getEmployeeID(@PathVariable(value="id") long employeeid ) throws ResourceNotFoundException
{
	Employee employee = emprepository.findById(employeeid).orElseThrow(()-> new ResourceNotFoundException("Employee not found : "+employeeid));
	return ResponseEntity.ok().body(employee);
				
}
@PutMapping("/employees/{id}")
public ResponseEntity<Employee> UpdateEmployee(@PathVariable(value="id") long employeeid, @RequestBody Employee employeedetails) throws ResourceNotFoundException
{
	Employee employee = emprepository.findById(employeeid).orElseThrow(()-> new ResourceNotFoundException("Employee not found : "+employeeid));
		
		  employee.setEmailID(employeedetails.getEmailID());
		  employee.setFirstName(employeedetails.getFirstName());
		  employee.setLastName(employeedetails.getLastName());
		  employee.setEmployeeName(employeedetails.getEmployeeName());
		  employee.setEmployeeStatus(employeedetails.getEmployeeStatus());
		  employee.setPassword(employeedetails.getPassword());
		  employee.setPhoneNumber(employeedetails.getPhoneNumber());
		 
	emprepository.save(employee);	
	return ResponseEntity.ok().body(employee);	
}
@DeleteMapping("/employees/{id}")
public ResponseEntity<Employee> DeleteEmployee(@PathVariable(value="id") long employeeid, @RequestBody Employee employeedetails) throws ResourceNotFoundException
{
	emprepository.findById(employeeid).orElseThrow(()-> new ResourceNotFoundException("Employee not found : "+employeeid));
		emprepository.deleteById(employeeid);	
	return ResponseEntity.ok().build();
}
}
