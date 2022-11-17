/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Nov 16, 2022
 */
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Movie;

public interface MovieRepository extends JpaRepository<Movie, String>{

}
