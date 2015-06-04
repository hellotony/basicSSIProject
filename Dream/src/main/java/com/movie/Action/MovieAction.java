package com.movie.Action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.Service.MovieService;

@Controller
public class MovieAction {
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/movieList")
	public String movieList(Model model,HttpServletRequest request){
		model.addAttribute("name", "movie");
		return "/mainList";
	}
	
	@RequestMapping("/movieDetail")
	public String movieDetail(Model model,HttpServletRequest request){
		model.addAttribute("name", "movieDetail");
		return "/detail";
	}

}
