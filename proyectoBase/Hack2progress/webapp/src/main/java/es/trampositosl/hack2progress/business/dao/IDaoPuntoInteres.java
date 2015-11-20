/**
 * 
 */
package es.trampositosl.hack2progress.business.dao;


import java.io.Serializable;
import java.util.List;
import es.trampositosl.hack2progress.business.domain.ActividadDeportiva;


/**
 * @author TrampositosSL
 *
 */
public interface IDaoPuntoInteres extends IDaoGenericInterface<ActividadDeportiva, Integer>
{

    public List<ActividadDeportiva> list();
}
