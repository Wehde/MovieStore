package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Customer {
	@Id
	@GeneratedValue private long id;
	private String firstName;
	private String lastName;
	
	//**Maybe we could add in a total # of orders and payment info later.
	//**Could do total dollar spent and at every x amount get a free rental or something


}
