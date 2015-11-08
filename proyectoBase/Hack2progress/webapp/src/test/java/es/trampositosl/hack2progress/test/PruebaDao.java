package es.trampositosl.hack2progress.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import es.trampositosl.hack2progress.business.domain.PuntoInteres;
import es.trampositosl.hack2progress.business.domain.TipoPuntoInteres;


public class PruebaDao {

	private Logger log = LoggerFactory.getLogger(PruebaDao.class);
	private DriverManagerDataSource dataSource;

	public PruebaDao() {

		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dataSource.setUsername("hach2progress");
		dataSource.setPassword("hach2progress");

		Properties properties = new Properties();
		properties.setProperty("initialSize", "200");
		properties.setProperty("maxActive", "200");

		properties.setProperty("maxConnectionsPerPartition", "200");
		properties.setProperty("minConnectionsPerPartition", "1");
		properties.setProperty("partitionCount", "1");

		dataSource.setConnectionProperties(properties);

	}
	
	

	public List<PuntoInteres> getPuntoInteres(String codigoCertificado) throws Exception {
		List<PuntoInteres> listPuntoInteres = new ArrayList<PuntoInteres>();
		String query = "select ID_DATOS_PRUEBA, TIPO_SERVICIO, ID_ENTORNO, CODIGO_CERTIFICADO, TIPO_DOCUMENTO, DOCUMENTO, NOMBRE, APELLIDO1, APELLIDO2, FECHA_INI, FECHA_FIN, NUMERO_SOPORTE, NACIONALIDAD_ESPANOLA, ACTIVO, RESPUESTA FROM DATOS_PRUEBA WHERE ACTIVO=1 AND CODIGO_CERTIFICADO = \'" + codigoCertificado + "\'";
		log.info("SQL ->" + query);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			mapeoListPuntoInteres(rs, listPuntoInteres);
			return listPuntoInteres;
		} catch (SQLException e) {
			log.error("*******************************************************************************************************************");
			log.error("*******************************************************************************************************************");
			log.error("ERROR MUY GRAVE");
			log.error("REVISAR ANTES DE SEGUIR HACIENDO NADA");
			log.error("*******************************************************************************************************************");
			log.error("*******************************************************************************************************************");
			log.error("Error->" + e);
			log.error("*******************************************************************************************************************");
			log.error("*******************************************************************************************************************");
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				log.error("*******************************************************************************************************************");
				log.error("*******************************************************************************************************************");
				log.error("ERROR MUY GRAVE");
				log.error("REVISAR ANTES DE SEGUIR HACIENDO NADA");
				log.error("*******************************************************************************************************************");
				log.error("*******************************************************************************************************************");
				log.error("Error->" + e);
				log.error("*******************************************************************************************************************");
				log.error("*******************************************************************************************************************");
				e.printStackTrace();
				throw new Exception(e);
			}
		}

	}

	private void mapeoListPuntoInteres(ResultSet rs, List<PuntoInteres> listPuntoInteres) {
		try {
			while (rs.next()) {
				PuntoInteres puntoInteres = new PuntoInteres();
				if(rs.getObject(0)!=null){
					puntoInteres.setIdPuntoInteres(Integer.valueOf(rs.getObject(0) + ""));
				}
				if(rs.getObject(1)!=null){
					puntoInteres.setNombre((String) rs.getObject(1));
				}
				if(rs.getObject(2)!=null){
					puntoInteres.setDescripcion((String) rs.getObject(2));
				}
				if(rs.getObject(3)!=null){
					puntoInteres.setLatitud((String) rs.getObject(3));
				}
				if(rs.getObject(4)!=null){
					puntoInteres.setLongitud((String) rs.getObject(4));
				}
				if(rs.getObject(5)!=null){
					puntoInteres.setTipoPuntoInteres((TipoPuntoInteres) rs.getObject(5));
				}
				if(rs.getObject(6)!=null){
					puntoInteres.setCiudad((String) rs.getObject(6));
				}
				if(rs.getObject(7)!=null){
					puntoInteres.setComunidadAutonoma((String) rs.getObject(7));
				}
				if(rs.getObject(8)!=null){
					puntoInteres.setUrl((String) rs.getObject(8));
				}
				if(rs.getObject(9)!=null){
					puntoInteres.setImagen((byte[]) rs.getObject(9));
				}
				if(rs.getObject(10)!=null){
					puntoInteres.setFechaCreacion((Calendar) rs.getObject(10));
				}
				if(rs.getObject(11)!=null){
					puntoInteres.setFechaModificacion((Calendar) rs.getObject(11));
				}
				if(rs.getObject(12)!=null){
					puntoInteres.setFechaBaja((Calendar) rs.getObject(12));
				}
				listPuntoInteres.add(puntoInteres);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insert(PuntoInteres puntoInteres) throws Exception {
		String query = "INSERT INTO PUNTO_INTERES VALUES (SEQ_PUNTO_INTERES.nextval, '"+ puntoInteres.getNombre()+"', '"+puntoInteres.getDescripcion()+"', '"+puntoInteres.getLatitud()+"', '"+puntoInteres.getLongitud()+"', "+puntoInteres.getTipoPuntoInteres().getIdTipoPuntoInteres()+", '"+puntoInteres.getCiudad()+"', '"+puntoInteres.getComunidadAutonoma()+"', '"+puntoInteres.getUrl()+"', null, TO_DATE('"+puntoInteres.getFechaCreacionS()+"', 'yyyy-MM-dd'), null, null)";
//		String query = "INSERT INTO PUNTOS_INTERES VALUE(SEQ_PUNTO_INTERES.nextval, "+ puntoInteres.getNombre()+", "+puntoInteres.getDescripcion()+", "+puntoInteres.getLatitud()+", "+puntoInteres.getLongitud()+", "+puntoInteres.getTipoPuntoInteres().getIdTipoPuntoInteres()+", "+puntoInteres.getCiudad()+", "+puntoInteres.getComunidadAutonoma()+", "+puntoInteres.getUrl()+")";
		query.replace("'null'", "null");
		log.info("SQL ->" + query);
		System.out.println("SQL ->" + query);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);

			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			log.error("*******************************************************************************************************************");
			log.error("*******************************************************************************************************************");
			log.error("ERROR MUY GRAVE");
			log.error("REVISAR ANTES DE SEGUIR HACIENDO NADA");
			log.error("*******************************************************************************************************************");
			log.error("*******************************************************************************************************************");
			log.error("Error->" + e);
			log.error("*******************************************************************************************************************");
			log.error("*******************************************************************************************************************");
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				log.error("*******************************************************************************************************************");
				log.error("*******************************************************************************************************************");
				log.error("ERROR MUY GRAVE");
				log.error("REVISAR ANTES DE SEGUIR HACIENDO NADA");
				log.error("*******************************************************************************************************************");
				log.error("*******************************************************************************************************************");
				log.error("Error->" + e);
				log.error("*******************************************************************************************************************");
				log.error("*******************************************************************************************************************");
				e.printStackTrace();
				throw new Exception(e);
			}
		}
		
	}

}
