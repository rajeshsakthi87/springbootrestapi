package org.restserviceapplicationrabo.repository;

import java.util.List;

import org.restserviceapplicationrabo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	

}
