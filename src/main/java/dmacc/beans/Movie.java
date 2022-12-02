/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Nov 16, 2022
 */
package dmacc.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Movie {
	//Variables
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String genre; //Could create bean for genre as well.
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate releaseDate;
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * @return the releaseDate
	 */
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	//Constructors
	/**
	 * 
	 */
	public Movie() {
		super();
	}
	/**
	 * @param name
	 * @param genre
	 * @param releaseDate
	 */
	public Movie(String name, String genre, LocalDate releaseDate) {
		super();
		this.name = name;
		this.genre = genre;
		this.releaseDate = releaseDate;
	}
	/**
	 * @param id
	 * @param name
	 * @param genre
	 * @param releaseDate
	 */
	public Movie(long id, String name, String genre, LocalDate releaseDate) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.releaseDate = releaseDate;
	}
	
	//Methods
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", genre=" + genre + ", releaseDate=" + releaseDate + "]";
	}
	
	
	
}
