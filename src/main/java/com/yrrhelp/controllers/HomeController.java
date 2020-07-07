package com.yrrhelp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showHomePage() {
		
		System.out.println("In Home Page");
		
		return "home";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam("uname") String uname, @RequestParam("psw") String psw)
	{
		if(uname.equals("virtusa") && psw.equals("virtusa"))
			return "redirect:/products/all";
		else
			return "home";
	}
}
