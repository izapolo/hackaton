import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import es.trampositosl.hack2progress.business.domain.PuntoInteres;


public class PruebaDao {

	private Logger log = LoggerFactory.getLogger(PruebaDao.class);
	private DriverManagerDataSource dataSource;

	public PruebaDao() {

		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dataSource.setUsername("hack2progress");
		dataSource.setPassword("hack2progress");

		Properties properties = new Properties();
		properties.setProperty("initialSize", "200");
		properties.setProperty("maxActive", "200");

		properties.setProperty("maxConnectionsPerPartition", "200");
		properties.setProperty("minConnectionsPerPartition", "1");
		properties.setProperty("partitionCount", "1");

		dataSource.setConnectionProperties(properties);

	}
	
	public Integer getSequencePuntoInteres() throws Exception {
		
		String query = "select SEQ_PUNTO_INTERES.nextval from dual";
		log.info("SQL ->" + query);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);

			rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getObject(0)!=null){
					Integer sequence=new Integer(rs.getObject(0).toString());
					return sequence;
				}
				
			}
			
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
		return null;
		
		
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
				PuntoInteres PuntoInteres = new PuntoInteres();
				PuntoInteres.setIdPuntoInteres(Integer.valueOf(rs.getObject(1) + ""));
			
				listPuntoInteres.add(PuntoInteres);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
