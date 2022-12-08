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

@Entity
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
}
