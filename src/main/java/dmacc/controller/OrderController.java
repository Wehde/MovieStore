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


import dmacc.beans.Orders;
import dmacc.repository.CustomerRepo;
import dmacc.repository.EmployeeRepo;
import dmacc.repository.MovieRepo;
import dmacc.repository.OrderRepo;
import dmacc.beans.Customer;
import dmacc.beans.Employee;
import dmacc.beans.Movie;


@Controller
@RequestMapping(value = "/orders")
public class OrderController {
	@Autowired
	OrderRepo repo;
	@Autowired
	CustomerRepo cRepo;
	@Autowired
	EmployeeRepo eRepo;
	@Autowired
	MovieRepo mRepo;
	
	
	@ModelAttribute("customers")
    public List<Customer> customers() {
        return cRepo.findAll();
    }
	
	@ModelAttribute("employees")
    public List<Employee> employees() {
        return eRepo.findAll();
    }
	
	@ModelAttribute("movies")
    public List<Movie> movies() {
        return mRepo.findAll();
    }

	@GetMapping({ "/", "viewAll" })
	public String viewAllOrders(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewOrder(model);
		}
		model.addAttribute("orders", repo.findAll());
		return "ViewAllOrders";
	}

	@GetMapping("/inputOrder")
	public String addNewOrder(Model model) {
		Orders o = new Orders();
		model.addAttribute("newOrder", o);
		return "PlaceOrder";
	}

	@PostMapping("/inputOrder")
	public String addNewOrder(@ModelAttribute Orders o, Model model) {
		repo.save(o);
		return viewAllOrders(model);
	}

	@GetMapping("/edit/{id}")
	public String showUpdateOrder(@PathVariable("id") long id, Model model) {
		Orders o = repo.findById(id).orElse(null);
		model.addAttribute("newBottle", o);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String reviseOrder(Orders o, Model model) {
		repo.save(o);
		return viewAllOrders(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteOrder(@PathVariable("id") long id, Model model) {
		Orders o = repo.findById(id).orElse(null);
		repo.delete(o);
		return viewAllOrders(model);
	}
	
	
	

}
