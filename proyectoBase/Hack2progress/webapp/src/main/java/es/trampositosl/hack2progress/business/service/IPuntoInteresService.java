/**
 * 
 */
package es.trampositosl.hack2progress.business.service;


import java.util.List;
import es.trampositosl.hack2progress.business.domain.PuntoInteres;


/**
 * @author TrampositosSL
 *
 */
public interface IPuntoInteresService
{

    public List<PuntoInteres> list();
    
    public PuntoInteres find(Integer id);
}
