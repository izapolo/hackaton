/**
 * 
 */
package es.trampositosl.hack2progress.business.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author jcamus
 *
 */
@Entity(name = "TIPO_PUNTO_INTERES")
public class TipoPuntoInteres {

	@Id
	@Column(name = "ID_TIPO_PUNTO_INTERES")
	private Integer idTipoPuntoInteres;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	/**
	 * @return the idTipoPuntoInteres
	 */
	public Integer getIdTipoPuntoInteres() {
		return idTipoPuntoInteres;
	}
	/**
	 * @param idTipoPuntoInteres the idTipoPuntoInteres to set
	 */
	public void setIdTipoPuntoInteres(Integer idTipoPuntoInteres) {
		this.idTipoPuntoInteres = idTipoPuntoInteres;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TipoPuntoInteres [idTipoPuntoInteres=" + idTipoPuntoInteres
				+ ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	

}
