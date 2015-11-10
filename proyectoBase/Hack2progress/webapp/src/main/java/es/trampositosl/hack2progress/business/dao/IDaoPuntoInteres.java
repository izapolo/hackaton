/**
 * 
 */
package es.trampositosl.hack2progress.business.dao;


import java.io.Serializable;
import java.util.List;
import es.trampositosl.hack2progress.business.domain.PuntoInteres;


/**
 * @author TrampositosSL
 *
 */
public interface IDaoPuntoInteres extends IDaoGenericInterface<PuntoInteres, Integer>
{

    public List<PuntoInteres> list();
}
