package br.edu.ifma.corpsystem.gestanteadmin.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePage {

	@RequestMapping("/")
	public String getView() {
		return "index";
	}
	
	@RequestMapping("naoTemPermissao")
	public String getNaoTemPermissao() {
		return "naoTemPermissao";
	}
	
}
