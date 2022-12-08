/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Dec 1, 2022
 */
package dmacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Customer;
import dmacc.beans.Rental;

public interface RentalRepo extends JpaRepository<Rental, Long>{
	
	List<Rental> findByRenteeOrderByDueDate(Customer customer);
	
}
