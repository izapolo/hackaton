package es.trampositosl.hack2progress.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;

import es.trampositosl.hack2progress.business.domain.PuntoInteres;
import es.trampositosl.hack2progress.business.domain.TipoPuntoInteres;

public class TestJson {

	@Test
	public void test() {
		PruebaDao pruebaDao=new PruebaDao();
		try{
		File archivo = new File ("./src/test/resources/json/taxis_paradas.json");
		FileReader fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);
		
		String json="";
		String linea = "";
		 while((linea=br.readLine())!=null){
			 json+=linea;
		 }
		 Gson gson = new Gson();
		 Map<String, List<Map>> objectResputa = gson.fromJson(json,  Map.class);
		 List<Map> listContenido=objectResputa.get("resources");
		 
		 TipoPuntoInteres tipoPuntoInteres=new TipoPuntoInteres();
		 tipoPuntoInteres.setIdTipoPuntoInteres(1);
		 tipoPuntoInteres.setNombre("Parada Taxi");
		 tipoPuntoInteres.setDescripcion("Parada Taxi");
		 
		 List<PuntoInteres> listPuntoInteres=new ArrayList<PuntoInteres>();
		 for (Map<String, String> contenido : listContenido) {
			 Calendar fechaActualC=Calendar.getInstance();
			 PuntoInteres puntoInteres=new PuntoInteres();
			 
			 puntoInteres.setNombre(contenido.get("ayto:descripcion"));
			 puntoInteres.setLatitud(contenido.get("ayto:latitud"));
			 puntoInteres.setLongitud(contenido.get("ayto:longitud"));
			 puntoInteres.setCiudad(contenido.get("ayto:ciudad"));
			 puntoInteres.setComunidadAutonoma("Cantabria");
			 puntoInteres.setUrl(contenido.get("uri"));			
			 puntoInteres.setTipoPuntoInteres(tipoPuntoInteres);
			 puntoInteres.setFechaCreacion(fechaActualC);
			 listPuntoInteres.add(puntoInteres);
		 }
			 
		 
		 for (PuntoInteres puntoInteres : listPuntoInteres) {
			pruebaDao.insert(puntoInteres);
		}
//		 Map<String, String> contenido=(Map<String, String>) listContenido.get(0);
		 
//		 properties.get("resources").get("ayto:longitud");
		 
		
		}catch (Exception e){
			e.printStackTrace();
		}
			
	}
//	
//	@Test
//	public void dosTest() {
//		
//		try{
//			PruebaDao pruebaDao=new PruebaDao();
//			
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}

}
