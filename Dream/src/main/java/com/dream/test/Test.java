package com.dream.test;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
	
	@Autowired
	private TestService service;
	
	@RequestMapping("/test")
	public String Test(Model model,HttpServletRequest request){
		model.addAttribute("name", "freemaker is successful");
	    request.getSession().setAttribute("name", "session test successful!");
		return "/index";
	}
	
	
	
}
