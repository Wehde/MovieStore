package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Orders {
	@Id
	@GeneratedValue private long id;
	//Ill add the ability to do more than one movie in an order later
	//ArrayList<Movie> movies;
	@ManyToOne
	Movie movie;
	String orderMovieTitle;
	//Customer customer;
	String orderCustomerName;
	//Employee employee;
	String orderEmployeeName;
	String buyOrRent;
	String orderQuantity;
}
