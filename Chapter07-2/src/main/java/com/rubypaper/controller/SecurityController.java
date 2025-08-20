package com.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//특정 URL 요청에 대한 view 

@Controller
public class SecurityController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member")
	public void member() {
	}
	
	@GetMapping("/manager")
	public void manager() {
	}
	
	@GetMapping("/admin")
	public void admin() {
	}

}
