package br.edu.ifma.corpsystem.gestanteadmin.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifma.corpsystem.gestanteadmin.model.Dica;
import br.edu.ifma.corpsystem.gestanteadmin.model.Usuario;
import br.edu.ifma.corpsystem.gestanteadmin.repository.UsuarioDao;

@Controller
public class UsuariosPage {
	@Autowired
	private UsuarioDao usuarioDao;
	
	@GetMapping("/usuarios")
	public ModelAndView getView() {
		Iterable<Usuario> usuarios = usuarioDao.findAll();
		ModelAndView modelAndView = new ModelAndView("usuarios");
		modelAndView.addObject("usuarios", usuarios);
		
		return modelAndView;
	}
	
	@GetMapping("/addUsuario")
	public ModelAndView getAddDicas(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("addUsuario");
		return modelAndView;
	}
	
	@PostMapping("/salvaUsuario")
	public ModelAndView salvaDica(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("redirect:/usuarios");
		usuarioDao.save(usuario);
		return modelAndView;
	}

	@GetMapping("/usuarioEditar")
	public ModelAndView editaUsuario(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("/addUsuario");
		Usuario usuario = usuarioDao.findById(id);
		modelAndView.addObject("usuario", usuario);
		return modelAndView;
	}
	@GetMapping("/usuarioDeletar")
	public ModelAndView removeUsuario(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/usuarios");
		Usuario usuario = usuarioDao.findById(id);
		usuarioDao.delete(usuario);
		return modelAndView;
	}

}
