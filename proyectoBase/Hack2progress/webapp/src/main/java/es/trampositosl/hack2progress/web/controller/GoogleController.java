package es.trampositosl.hack2progress.web.controller;


import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import es.trampositosl.hack2progress.business.domain.PuntoInteres;
import es.trampositosl.hack2progress.business.service.IPuntoInteresService;


@Controller
@RequestMapping("/google")
public class GoogleController
{

    @Autowired
    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleController.class);

    @Autowired
    public IPuntoInteresService puntoInteresService;


    /**
     * Pintar puntos en el mapa
     * 
     * @return
     */
    @RequestMapping(value = "/getMap")
    public String getMap(ModelMap model, HttpServletRequest request)
    {

	LOGGER.debug("getMap");
	List<PuntoInteres> listPuntoInteres = new ArrayList<PuntoInteres>();
	listPuntoInteres = puntoInteresService.list();

	Gson gson = new Gson();
	String json = gson.toJsonTree(listPuntoInteres).toString();
	model.put("json", json);
	return "getMap";
    }


    /**
     * Pintar camino de los puntos en el mapa
     * 
     * @return
     */
    @RequestMapping(value = "/getWayMap")
    public String getWayMap(ModelMap model, HttpServletRequest request)
    {

	LOGGER.debug("getWayMap");
	List<PuntoInteres> listPuntoInteres = new ArrayList<PuntoInteres>();
	List<PuntoInteres> listPuntoInteres2 = new ArrayList<PuntoInteres>();
	listPuntoInteres = puntoInteresService.list();

	listPuntoInteres2.add(listPuntoInteres.get(0));
	listPuntoInteres2.add(listPuntoInteres.get(listPuntoInteres.size() - 1));

	Gson gson = new Gson();
	String json = gson.toJsonTree(listPuntoInteres2).toString();
	model.put("json", json);
	return "getWayMap";
    }


    @RequestMapping(value = "/getJsonWayMap", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<PuntoInteres> getWayMapJ()
    {

	LOGGER.debug("getWayMapJ");
	List<PuntoInteres> listPuntoInteres = new ArrayList<PuntoInteres>();
	List<PuntoInteres> listPuntoInteres2 = new ArrayList<PuntoInteres>();
	listPuntoInteres = puntoInteresService.list();

	listPuntoInteres2.add(listPuntoInteres.get(0));
	listPuntoInteres2.add(listPuntoInteres.get(listPuntoInteres.size() - 1));

	return listPuntoInteres2;
    }


    @RequestMapping(value = "/0")
    public String index0(ModelMap model, HttpServletRequest request)
    {

	return "0Template";
    }


    @RequestMapping(value = "/1")
    public String index1(ModelMap model, HttpServletRequest request)
    {

	return "1Template";
    }


    @RequestMapping(value = "/2")
    public String index2(ModelMap model, HttpServletRequest request)
    {

	return "2Template";
    }


    @RequestMapping(value = "/3")
    public String index3(ModelMap model, HttpServletRequest request)
    {

	return "3Template";
    }


    @RequestMapping(value = "/4")
    public String index4(ModelMap model, HttpServletRequest request)
    {

	return "4Template";
    }

}
