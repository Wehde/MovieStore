/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Nov 16, 2022
 */
package dmacc.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Movie;

public interface MovieRepo extends JpaRepository<Movie, Long>{
	
	List<Movie> findByReleaseDateBetweenOrderByReleaseDate(LocalDate startDate, LocalDate endDate);
	
	List<Movie> findByReleaseDateBeforeOrderByGenre(LocalDate endDate);
}
