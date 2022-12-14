/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Nov 16, 2022
 */
package dmacc.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dmacc.beans.Movie;
import dmacc.repository.MovieRepo;

@Controller
@RequestMapping(value = "/movies")
public class MovieController {
	@Autowired
	MovieRepo repo;

	@GetMapping({ "/", "viewAll" })
	public String viewAllMovies(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewMovie(model);
		}
		model.addAttribute("movies", repo.findByReleaseDateBeforeOrderByGenre(LocalDate.now()));
		return "ViewAllMovies";
	}

	@GetMapping("/upcomingReleases")
	public String viewUpcomingMovies(Model model) {
		model.addAttribute("movies",
				repo.findByReleaseDateBetweenOrderByReleaseDate(LocalDate.now(), LocalDate.now().plusDays(30)));
		return "ViewAllMovies";
	}

	@GetMapping("/inputMovie")
	public String addNewMovie(Model model) {
		Movie m = new Movie();
		model.addAttribute("newMovie", m);
		return "AddMovie";
	}

	@PostMapping("/inputMovie")
	public String addNewMovie(@ModelAttribute Movie m, Model model) {
		repo.save(m);
		return viewAllMovies(model);
	}

	@GetMapping("/edit/{id}")
	public String showUpdateMovie(@PathVariable("id") long id, Model model) {
		Movie m = repo.findById(id).orElse(null);
		model.addAttribute("newMovie", m);
		return "AddMovie";
	}

	@PostMapping("/update/{id}")
	public String reviseMovie(Movie m, Model model) {
		repo.save(m);
		return viewAllMovies(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteMovie(@PathVariable("id") long id, Model model) {
		Movie m = repo.findById(id).orElse(null);
		repo.delete(m);
		return viewAllMovies(model);
	}

}
