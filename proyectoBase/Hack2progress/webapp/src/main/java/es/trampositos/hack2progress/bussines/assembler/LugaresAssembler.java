package es.trampositos.hack2progress.bussines.assembler;


import org.springframework.stereotype.Component;


@Component
public class LugaresAssembler
{

    public Lugar assembleLugar(LugarDto){
	Lugar lugar = new Lugar();
	lugar.setTipo(tipo);
	lugar.setNombre(nombre);
	lugar.setLongitud(longitud);
	lugar.setLatitud(latitud):
	lugar.setDescripcion(descripcion);
	lugar.setFechaAlta(fecha_alta);
	lugar.setFechaUltMod(new Date());
	return lugar;
    }
    
    public LugarDto<Lugar lugar>{
	
    }
}
