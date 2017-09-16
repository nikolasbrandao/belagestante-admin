package br.edu.ifma.corpsystem.gestanteadmin.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginPage {

	@RequestMapping("/login")
	public String getView() {
		return "login";
	}
	
	@PostMapping("/login")
	public String redirectHome() {
		return "/";
	}
}
