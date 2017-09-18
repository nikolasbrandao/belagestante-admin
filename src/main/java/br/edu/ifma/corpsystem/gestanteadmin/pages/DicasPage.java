package br.edu.ifma.corpsystem.gestanteadmin.pages;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifma.corpsystem.gestanteadmin.model.Dica;
import br.edu.ifma.corpsystem.gestanteadmin.repository.DicaDao;

//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.util.JRLoader;

@Controller
public class DicasPage {

	@Autowired
	private DicaDao dicaDao;

	@Autowired
	private ApplicationContext appContext;

	
	
	@GetMapping("/dicas")
	public ModelAndView getDicas() {
		Iterable<Dica> dicas = dicaDao.findAll();
		ModelAndView modelAndView = new ModelAndView("dicas");
		modelAndView.addObject("dicas", dicas);
		return modelAndView;
	}

	@GetMapping("/addDica")
	public ModelAndView getAddDicas(Dica dica) {
		ModelAndView modelAndView = new ModelAndView("addDica");
		return modelAndView;
	}

	@PostMapping("/salvaDica")
	public ModelAndView salvaDica(Dica dica, MultipartFile imagemDoProduto, HttpServletRequest request) {
		String uploadimg = request.getServletContext().getRealPath("/img-dicas");
		if(!imagemDoProduto.isEmpty()) {
			try {
				byte[] bytes = imagemDoProduto.getBytes();
				Path path = Paths.get(uploadimg +imagemDoProduto.getOriginalFilename());
				Files.write(path, bytes);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/dicas");
		dicaDao.save(dica);
		return modelAndView;
	}

	@GetMapping("/dicasEditar")
	public ModelAndView editaDica(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("addDica");
		Dica dica = dicaDao.findById(id);
		modelAndView.addObject("dica", dica);
		return modelAndView;
	}

	@GetMapping("/dicas/remover")
	public ModelAndView deletaDica(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/dicas");
		Dica dica = dicaDao.findById(id);
		dicaDao.delete(dica);
		return modelAndView;
	}

	@GetMapping("/relatorioDicas")
	public void imprimeRelatorioDicas(HttpServletResponse response) throws SQLException, IOException {
		// InputStream jasperStream =
		// this.getClass().getResourceAsStream("/reports/Invoice.jasper");
		// JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		// Map<String,Object> params = new HashMap<>();
		// Connection conn =
		// DriverManager.getConnection("jdbc:mysql://localhost/belagestante?useSSL=false",
		// "root", "100senha" );
		//
		// JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,
		// conn);
		//
		// response.setContentType("application/x-pdf");
		// response.setHeader("Content-disposition", "inline;
		// filename=relatorio-usuarios.pdf");
		//
		// final OutputStream outStream = response.getOutputStream();
		// JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	    
		//ModelAndView modelAndView = new ModelAndView("redirect:/dicas");
		//return modelAndView;
	}

}
