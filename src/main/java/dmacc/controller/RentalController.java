/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Dec 1, 2022
 */
package dmacc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dmacc.beans.Customer;
import dmacc.beans.Movie;
import dmacc.beans.Rental;
import dmacc.repository.CustomerRepo;
import dmacc.repository.MovieRepo;
import dmacc.repository.RentalRepo;

@Controller
@RequestMapping(value = "/rentals")
public class RentalController {
	@Autowired
	RentalRepo rRepo;
	@Autowired 
	MovieRepo mRepo;
	@Autowired
	CustomerRepo cRepo;
	
	@GetMapping({"/", "viewAll"})
	public String viewAllRentals(Model model) {
		if(rRepo.findAll().isEmpty()) {
			return addNewRental(model);
		}
		model.addAttribute("rentals", rRepo.findAll());
		return "ViewAllRentals";
	}
	
	@GetMapping({"/checkedOut/{id}"})
	public String viewCustomerRentals(@PathVariable("id") long id, Model model) {
		Customer c = cRepo.findById(id).orElse(null);
		
		model.addAttribute("customerRentals", rRepo.findByRenteeOrderByDueDate(c));
		
		return "customerRentalResults";
	}
	
	@GetMapping("/inputRental")
	public String addNewRental(Model model) {
		Rental r = new Rental();
		model.addAttribute("newRental", r);
		
		List<Movie> movies = mRepo.findAll();
		model.addAttribute("allMovies", movies);
		
		return "rentalInput";	
	}
	
	@PostMapping("/inputRental")
	public String addNewRental(@ModelAttribute Rental r, Model model) {
		rRepo.save(r);
		return viewAllRentals(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateRental(@PathVariable("id") long id, Model model) {
		Rental r = rRepo.findById(id).orElse(null);
		model.addAttribute("newRental", r);
		
		List<Movie> movies = mRepo.findAll();
		model.addAttribute("allMovies", movies);
		
		return "rentalInput";	
	}
	
	@PostMapping("/update/{id}")
	public String reviseRental(Rental r, Model model) {
		rRepo.save(r);
		return viewAllRentals(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteRental(@PathVariable("id") long id, Model model) {
		Rental r = rRepo.findById(id).orElse(null);
		rRepo.delete(r);
		return viewAllRentals(model);
	}
}
