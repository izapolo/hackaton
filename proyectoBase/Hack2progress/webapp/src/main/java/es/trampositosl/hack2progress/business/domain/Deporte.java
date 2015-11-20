package es.trampositosl.hack2progress.business.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


/**
 * @author jar
 *
 */
@Entity(name = "DEPORTE")
public class Deporte
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_deporte")
    @SequenceGenerator(name = "secuencia_deporte", sequenceName = "SEQ_DEPORTE")
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DESCRIPCION")
    private String descripcion;


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

}
