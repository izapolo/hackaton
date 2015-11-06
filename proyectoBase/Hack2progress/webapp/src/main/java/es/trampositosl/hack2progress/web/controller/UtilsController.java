package es.trampositosl.hack2progress.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UtilsController {
	/**
	 * mostrar pagina de registro de versiones
	 * 
	 * @return
	 */
	@RequestMapping(value = "/auth/utils/changelog")
	public String changeLog() {
		return "changeLogPage";
	}


}
