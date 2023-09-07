package com.instanotes.movies.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.instanotes.movies.dataaccess.MovieListRepository;
import com.instanotes.movies.model.Data;

@Controller
@RequestMapping("/")
public class MovieListController {

	@Autowired 
	private MovieListRepository mlr;
	
	@RequestMapping(method=RequestMethod.GET, value="/movies/{actor}")
	public String getMovieListByActor(@PathVariable("actor") String name, Model model) {
		
		/*List <Movie> ml = new ArrayList <Movie>();
		Data movie = new Data();
		movie.setName("MI series");
		movie.setDescription("Action film");
		movie.setActor("tom");
		ml.add(movie);*/
		
		List <Data> ml = mlr.findMoviesByActor(name);

		model.addAttribute("movies", ml);
		return "movieList";
	}
	@RequestMapping(method=RequestMethod.POST, value="/movies", consumes="application/json")
		public ResponseEntity<Object> addMovie(@RequestBody Data movie) {
		mlr.save(movie);
			return ResponseEntity.ok().build();
			
		}
}
