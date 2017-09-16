package br.edu.ifma.corpsystem.gestanteadmin.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SobrePage {
	
	@RequestMapping("/sobre")
	public String getView() {
		return "sobre";
	}
}
