/**
 * 
 */
package es.trampositosl.hack2progress.business.domain;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author jcamus
 *
 */
@Entity(name = "PUNTO_INTERES")
public class PuntoInteres {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia")
	@SequenceGenerator(name = "secuencia", sequenceName = "SEQ_PUNTO_INTERES")
	@Column(name = "ID_PUNTO_INTERES")
	private Integer idPuntoInteres;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "LATITUD")
	private String latitud;
	@Column(name = "LONGITUD")
	private String longitud; 	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "ID_TIPO_PUNTO_INTERES")
	private TipoPuntoInteres tipoPuntoInteres;	
	@Column(name = "CIUDAD")
	private String ciudad;
	@Column(name = "COMUNIDAD_AUTONOMA")
	private String comunidadAutonoma;
	@Column(name = "URL")
	private String url;
	@Column(name = "IMAGEN")
	private byte[] imagen;
	@Column(name = "FECHA_CREACION", columnDefinition = "timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaCreacion;
	@Column(name = "FECHA_MODIFICACION", columnDefinition = "timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaModificacion;
	@Column(name = "FECHA_BAJA", columnDefinition = "timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaBaja;
	/**
	 * @return the idPuntoInteres
	 */
	public Integer getIdPuntoInteres() {
		return idPuntoInteres;
	}
	/**
	 * @param idPuntoInteres the idPuntoInteres to set
	 */
	public void setIdPuntoInteres(Integer idPuntoInteres) {
		this.idPuntoInteres = idPuntoInteres;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the latitud
	 */
	public String getLatitud() {
		return latitud;
	}
	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	/**
	 * @return the longitud
	 */
	public String getLongitud() {
		return longitud;
	}
	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	/**
	 * @return the tipoPuntoInteres
	 */
	public TipoPuntoInteres getTipoPuntoInteres() {
		return tipoPuntoInteres;
	}
	/**
	 * @param tipoPuntoInteres the tipoPuntoInteres to set
	 */
	public void setTipoPuntoInteres(TipoPuntoInteres tipoPuntoInteres) {
		this.tipoPuntoInteres = tipoPuntoInteres;
	}
	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * @return the comunidadAutonoma
	 */
	public String getComunidadAutonoma() {
		return comunidadAutonoma;
	}
	/**
	 * @param comunidadAutonoma the comunidadAutonoma to set
	 */
	public void setComunidadAutonoma(String comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the imagen
	 */
	public byte[] getImagen() {
		return imagen;
	}
	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	/**
	 * @return the fechaCreacion
	 */
	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public String getFechaCreacionS() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String formatted = format1.format(fechaCreacion.getTime());
		return formatted;
	}
	/**
	 * @return the fechaModificacion
	 */
	public Calendar getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Calendar fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * @return the fechaBaja
	 */
	public Calendar getFechaBaja() {
		return fechaBaja;
	}
	/**
	 * @param fechaBaja the fechaBaja to set
	 */
	public void setFechaBaja(Calendar fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PuntoInteres [idPuntoInteres=" + idPuntoInteres + ", nombre="
				+ nombre + ", descripcion=" + descripcion + ", latitud="
				+ latitud + ", longitud=" + longitud + ", tipoPuntoInteres="
				+ tipoPuntoInteres + ", ciudad=" + ciudad
				+ ", comunidadAutonoma=" + comunidadAutonoma + ", url=" + url
				+ ", imagen=" + Arrays.toString(imagen) + ", fechaCreacion="
				+ fechaCreacion + ", fechaModificacion=" + fechaModificacion
				+ ", fechaBaja=" + fechaBaja + "]";
	}
	
	
	
}
