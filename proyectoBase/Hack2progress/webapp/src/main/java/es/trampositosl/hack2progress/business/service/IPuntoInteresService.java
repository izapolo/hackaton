/**
 * 
 */
package es.trampositosl.hack2progress.business.service;


import java.util.List;
import es.trampositosl.hack2progress.business.domain.ActividadDeportiva;


/**
 * @author TrampositosSL
 *
 */
public interface IPuntoInteresService
{

    public List<ActividadDeportiva> list();
    
    public ActividadDeportiva find(Integer id);
}
