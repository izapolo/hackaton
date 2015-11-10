package es.trampositosl.hack2progress.business.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.trampositosl.hack2progress.business.dao.IDaoGenericInterface;


/**
 * Implementacion del dao generico
 * 
 * @author Grupo JEE
 * 
 * @param <T>
 * @param <P>
 */
public class GenericJpaDao<T, P extends Serializable> implements IDaoGenericInterface<T, P> {

	@PersistenceContext
	protected EntityManager em;
    
	private static final Logger LOGGER = LoggerFactory.getLogger(GenericJpaDao.class);

	private Class<T> persistentClass;

    /**
	 * Constructor
	 */
	@SuppressWarnings("unchecked")
	public GenericJpaDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * crea una entidad t del tipo T
	 */
	public T create(final T t) {
		try {
			this.em.persist(t);
			return t;
		} catch (Exception ex) {
			LOGGER.error("GenericJpaDao.create(): " + ex.getMessage());
			return null;
		}
	}

	/**
	 * Elimina un Objeto por su id
	 */
	public boolean delete(final Object id) {
		try {
			this.em.remove(this.em.getReference(persistentClass, id));
			return true;
		} catch (Exception ex) {
			LOGGER.error("GenericJpaDao.delete(): " + ex.getMessage());
			return false;
		}
	}

	/**
	 * localiza un objeto por su id
	 */
	public T find(final Object id) {
		try {
			return (T) this.em.find(persistentClass, id);
		} catch (Exception ex) {
			LOGGER.error("GenericJpaDao.find(): " + ex.getMessage());
			return null;
		}
	}

	/**
	 * actualiza objeto t de tipo T
	 */
	public T update(final T t) {
		try {
			return this.em.merge(t);
		} catch (Exception ex) {
			LOGGER.error("GenericJpaDao.update(): " + ex.getMessage());
			return null;
		}
	}

	/**
	 * cuenta el numero de registros existentes en la entidad
	 */
	public long count() {
		long numRegistros;
		Query query = this.em.createQuery("Select count(r) from " + persistentClass.getName() + " r");
		numRegistros = ((Long) query.getSingleResult()).longValue();
		return numRegistros;
	}	
}
