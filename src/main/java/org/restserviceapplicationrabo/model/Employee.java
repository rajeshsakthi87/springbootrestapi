package org.restserviceapplicationrabo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="employees")
public class Employee implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	
	@Column(name = "employee_status")
	private long employeeStatus;
	
	@NotEmpty(message="employee name is mandatory")
	@Column(name = "employee_name")
	private String employeeName;
	
	@NotNull(message="first name is mandatory")
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull(message="last name is mandatory")
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name="email")
	private String emailID;
	
	@NotNull(message="password is mandatory")
	@Column(name="password")
	private String password;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
		
	public long getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(long employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
		
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
   public Employee(long id, long employeeStatus, String employeeName, String firstName, String lastName,
			String emailID, String password, String phoneNumber) {
		super();
		this.id = id;
		this.employeeStatus = employeeStatus;
		this.employeeName = employeeName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
}
