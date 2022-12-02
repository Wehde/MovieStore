package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Employee;

/**
 * @author kenne-krcutkomp
 * CIS175 - Fall 2022
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
