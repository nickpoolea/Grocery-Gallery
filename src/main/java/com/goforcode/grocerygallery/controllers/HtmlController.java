package com.goforcode.grocerygallery.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HtmlController {
	
	public HtmlController() {
		
	}
	
	@GetMapping("/")
	public ModelAndView loadIndex(HttpServletRequest request) {
		System.out.print(request.getRequestedSessionId());
		ModelAndView mv = new ModelAndView("/templates/index");
		System.out.println("Loading index");
		return mv;
	}

}
