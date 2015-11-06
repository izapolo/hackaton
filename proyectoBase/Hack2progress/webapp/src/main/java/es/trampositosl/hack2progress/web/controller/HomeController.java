package es.trampositosl.hack2progress.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	@Autowired
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Redirige el home de la apliacion
	 * 
	 * @return
	 */
	@RequestMapping(value = "/auth/home")
	public String home() {
		LOGGER.debug("Entrando en la app");
		return "homePage";
	}

}
