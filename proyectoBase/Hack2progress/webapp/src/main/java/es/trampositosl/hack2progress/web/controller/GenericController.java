package es.trampositosl.hack2progress.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador generico
 * @author Grupo JEE
 *
 */     
@Controller
public class GenericController {

	/**
	 * Pagina a presentar si hay error
	 * @return Identificador tiles de la pagina de error
	 */
	@RequestMapping(value = "/error")
	public String pageMissing(ModelMap model,HttpServletRequest request) {
		request.setAttribute("error", "Error general");
		return "genericErrorPage";
	}
	
	/**
	 * Pagina a presentar si no la pagina solicitada no existe
	 * @return Identificador tiles de la pagina de error
	 */
	@RequestMapping(value = "/missing")
	public String pageMissing() {
		return "pageMissingPage";
	}	
}
