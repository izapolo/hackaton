/**
 * 
 */
package es.trampositosl.hack2progress.business.dao.hibernate;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import es.trampositosl.hack2progress.business.dao.IDaoPuntoInteres;
import es.trampositosl.hack2progress.business.domain.ActividadDeportiva;


/**
 * @author TrampositosSL
 *
 */
@Repository
public class PuntoInteresDaoImpl extends GenericJpaDao<ActividadDeportiva, Integer> implements IDaoPuntoInteres
{

    public List<ActividadDeportiva> list(){
	
	
//	Criteria criteria = ((Session) em.getDelegate()).createCriteria(PuntoInteres.class);

//	if (StringUtils.isNotBlank(buscadorLicitadoresForm.getNif())) {
//		criteria.add(Restrictions.ilike("nif", buscadorLicitadoresForm.getNif(), MatchMode.ANYWHERE));
//	}
//	if (StringUtils.isNotBlank(buscadorLicitadoresForm.getRazonSocial())) {
//		criteria.add(Restrictions.ilike("razonSocial", buscadorLicitadoresForm.getRazonSocial(), MatchMode.ANYWHERE));
//	}
//	return criteria.list();
	
	
//	
	List<ActividadDeportiva> listPuntoInteres = new ArrayList<ActividadDeportiva>();
	Query query = this.em.createNativeQuery("SELECT * FROM PUNTO_INTERES", ActividadDeportiva.class);
	listPuntoInteres = query.getResultList(); 
	return listPuntoInteres;
    }
}
