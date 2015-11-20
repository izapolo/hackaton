/**
 * 
 */
package es.trampositosl.hack2progress.business.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


/**
 * @author jar
 *
 */

@Entity(name = "INSCRIPCION_GRUPO")
public class InscripcionGrupo
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_inscripcion_grupo")
    @SequenceGenerator(name = "secuencia_inscripcion_grupo", sequenceName = "SEQ_INSCRIPCION_GRUPO")
    @Column(name = "ID")
    private Integer id;
    @ManyToOne(cascade =
    { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "ID_QUEDADA")
    private Quedada quedada;
    @ManyToOne(cascade =
    { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "ID_DEPORTE")
    private Deporte deporte;


    public Integer getId()
    {

	return id;
    }


    public void setId(Integer id)
    {

	this.id = id;
    }


    public String getDescripcion()
    {

	return descripcion;
    }


    public void setDescripcion(String descripcion)
    {

	this.descripcion = descripcion;
    }


    public Deporte getDeporte()
    {

	return deporte;
    }


    public void setDeporte(Deporte deporte)
    {

	this.deporte = deporte;
    }

}