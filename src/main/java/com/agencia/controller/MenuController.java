package com.agencia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MenuController {
	
	@GetMapping("/about")
	public String About() {
        return "about";
    }
	
	@GetMapping("/tours")
	public String Tours() {
        return "tours-1";
    }
	
	@GetMapping("/contact")
	public String Contact() {
        return "contact";
    }
}
