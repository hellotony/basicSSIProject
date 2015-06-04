package com.dream.test;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.jdbc.StringUtils;

import freemarker.template.utility.StringUtil;

@Controller
public class MainAction {
	
	@Autowired
	private MainService service;
	
	//首页
	@RequestMapping("/index")
	public String Test(Model model,HttpServletRequest request){
		model.addAttribute("name", "freemaker is successful");
	    request.getSession().setAttribute("name", "session test successful!");
		return "/index";
	}
	
	//登录页面
	@RequestMapping("/login")
	public String login(Model model,HttpServletRequest request){
		model.addAttribute("name", "freemarer is successful");
		return "/login";
	}
	
	//登录
	@RequestMapping("/toLogin")
	public String toLogin(Model model,HttpServletRequest request,HttpSession session,User user){
		user = service.getUserByName(request.getParameter("name"));
		if(user == null){
			return "/login";
		}
		if(user.getPassword()!=null && user.getPassword().equals(request.getParameter("password") )){
			session.setAttribute("user", user);
		}
		return "/index";
	}
	
	//注册页面
	@RequestMapping("/register")
	public String registration(Model model,HttpServletRequest request,HttpSession session){
		model.addAttribute("name", "freemarer is successful");
		User user = (User) session.getAttribute("user");
		return "/register";
	}
	
	//注册
	@RequestMapping("/toRegister")
	public String toRegister(Model model,HttpServletRequest request,User user,HttpSession session){
		String password = request.getParameter("password");
		if(!(password !=null &&password.equals(request.getParameter("password1")))){
			return "/register";
		}
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));
		user.setRemark(request.getParameter("remark"));
		user.setCreateTime(new Date());
		service.saveUser(user);
		//插入session
		session.setAttribute("user", user);
		return "/index";
	}
	
	
	
	
	
	
}
