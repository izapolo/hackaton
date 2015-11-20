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

@Entity(name = "ACTIVIDAD_DEPORTIVA")
public class ActividadDeportiva
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_actividad_deportiva")
    @SequenceGenerator(name = "secuencia_actividad_deportiva", sequenceName = "SEQ_ACTIVIDAD_DEPORTIVA")
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DESCRIPCION")
    private String DESCRIPCION;
    @ManyToOne(cascade =
    { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "ID_DEPORTE")
    private Deporte deporte;

}