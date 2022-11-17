package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dmacc.beans.Customer;
import dmacc.repository.CustomerRepo;


@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	CustomerRepo repo;
	
	@GetMapping({"/", "viewAll"})
	public String viewAllCustomers(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewCustomer(model);
		}
		model.addAttribute("customers", repo.findAll());
		return "ViewAllCustomers";
	}
	
	@GetMapping("/inputCustomer")
	public String addNewCustomer(Model model) {
		Customer c = new Customer();
		model.addAttribute("newCustomer", c);
		return "AddCustomer";
	}
	
	@PostMapping("/inputCustomer")
	public String addNewCustomer(@ModelAttribute Customer c, Model model) {
		repo.save(c);
		return viewAllCustomers(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateCustomer(@PathVariable("id") long id, Model model) {
		Customer c = repo.findById(id).orElse(null);
		model.addAttribute("newCustomer", c);
		return "AddCustomer";
	}
	
	@PostMapping("/update/{id}")
	public String reviseCustomer(Customer c, Model model) {
		repo.save(c);
		return viewAllCustomers(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable("id") long id, Model model) {
		Customer c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllCustomers(model);
	}

}
