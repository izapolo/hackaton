package es.trampositosl.hack2progress.web.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoginController.class);

	/**
	 * url por defecto si no se esta autenticado se va a la pagina de login
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/*")
	public String doLogin(HttpServletRequest request) {
		LOGGER.debug("Autenticando");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth.getName().equalsIgnoreCase("anonymousUser")) {
			return "loginPage";
		} else {
			return "redirect:/auth/home";
		}
	}

	/**
	 * Pagina a presentar si expira la sesion
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sessionTimeOut")
	public String sessionTimeout() {
		return "sessionTimeOutPage";
	}

	/**
	 * pagina a presentar si no se tiene autorizacion
	 * 
	 * @return
	 */
	@RequestMapping(value = "/accessDenied")
	public String accessDenied() {
		return "accessDeniedPage";
	}

}
