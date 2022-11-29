package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Employee;

/**
 * @author kenne-krcutkomp
 * CIS175 - Fall 2022
 */
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
