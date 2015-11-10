/**
 * 
 */
package es.trampositosl.hack2progress.business.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import es.trampositosl.hack2progress.business.dao.IDaoPuntoInteres;
import es.trampositosl.hack2progress.business.domain.PuntoInteres;
import es.trampositosl.hack2progress.business.service.IPuntoInteresService;


/**
 * @author TrampositosSL
 *
 */
@Service(value="puntoInteresService")
@Transactional
public class PuntoInteresServiceImpl implements IPuntoInteresService
{

    @Autowired
    public IDaoPuntoInteres daoPuntoInteres;


    public PuntoInteresServiceImpl()
    {

    }


    public List<PuntoInteres> list()
    {

	return daoPuntoInteres.list();
    }


    public PuntoInteres find(Integer id)
    {
	return daoPuntoInteres.find(id.intValue());
    }
    
    
    
    
    

}
