package dmacc.controller;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import dmacc.beans.Orders;
import dmacc.repository.CustomerRepo;
import dmacc.repository.OrderRepo;
import dmacc.beans.Customer;


@Controller
@RequestMapping(value = "/orders")
public class OrderController {
	@Autowired
	OrderRepo repo;
	CustomerRepo cRepo;
	
	
	@ModelAttribute("customers")
    public List<Customer> messages() {
        return cRepo.findAll();
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
