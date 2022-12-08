/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Dec 1, 2022
 */
package dmacc.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Rental {
	@Id
	@GeneratedValue 
	private long id;
	@ManyToOne
	private Movie movie;
	@ManyToOne
	private Customer rentee;
	private double rate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate rentedDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dueDate;
	
	//Getters and Setters
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}
	/**
	 * @param movie the movie to set
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	/**
	 * @return the rentee
	 */
	public Customer getRentee() {
		return rentee;
	}
	/**
	 * @param rentee the rentee to set
	 */
	public void setRentee(Customer rentee) {
		this.rentee = rentee;
	}
	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}
	/**
	 * @return the rentedDate
	 */
	public LocalDate getRentedDate() {
		return rentedDate;
	}
	/**
	 * @param rentedDate the rentedDate to set
	 */
	public void setRentedDate(LocalDate rentedDate) {
		this.rentedDate = rentedDate;
	}
	/**
	 * @return the dueDate
	 */
	public LocalDate getDueDate() {
		return dueDate;
	}
	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	//Constructors
	/**
	 * 
	 */
	public Rental() {
		super();
	}
	/**
	 * @param movie
	 * @param rate
	 */
	public Rental(Movie movie, double rate) {
		super();
		this.movie = movie;
		this.rate = rate;
	}
	/**
	 * @param id
	 * @param movie
	 * @param rate
	 */
	public Rental(long id, Movie movie, double rate) {
		super();
		this.id = id;
		this.movie = movie;
		this.rate = rate;
	}
	
	
	
}
