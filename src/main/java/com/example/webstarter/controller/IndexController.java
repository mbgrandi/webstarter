package com.example.webstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping(value = { "/", "/index", "/dashboard" })
	public String upload(Model model) {	
		return "index";
	}
}
