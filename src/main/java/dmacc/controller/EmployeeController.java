package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import dmacc.beans.Employee;
import dmacc.repository.EmployeeRepo;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {
	@Autowired
	EmployeeRepo repo;
	
	@GetMapping({"/", "viewAll"})
	public String viewAllEmployees(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewEmployee(model);
		}
		model.addAttribute("employees", repo.findAll());
		return "ViewAllEmployees";
	}
	
	@GetMapping("/inputEmployee")
	public String addNewEmployee(Model model) {
		Employee e = new Employee();
		model.addAttribute("newEmployee", e);
		return "AddEmployee";
	}
	
	@PostMapping("/inputEmployee")
	public String addNewEmployee(@ModelAttribute Employee e, Model model) {
		repo.save(e);
		return viewAllEmployees(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateEmployee(@PathVariable("id") long id, Model model) {
		Employee e = repo.findById(id).orElse(null);
		model.addAttribute("newEmployee", e);
		return "AddEmployee";
	}
	
	@PostMapping("/update/{id}")
	public String reviseEmployee(Employee e, Model model) {
		repo.save(e);
		return viewAllEmployees(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") long id, Model model) {
		Employee e = repo.findById(id).orElse(null);
		repo.delete(e);
		return viewAllEmployees(model);
	}

}
