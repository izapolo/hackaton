package es.trampositosl.hack2progress.business.dao;
     
import java.io.Serializable;


/** 
 * Interfaz con las operaciones de un dao generico 
 * @author Grupo JEE
 *
 * @param <T>
 * @param <P>
 */
public interface IDaoGenericInterface<T, P extends Serializable> {
	
	/**
	 * crear una nueva entidad t del tipo T
	 */
    T create(T t);
    
    /**
     * borrar entidad por su id
     */
    boolean delete(Object id);
    
    /** 
     * encontrar una entidad por su id
     */
    T find(Object id);
    
    /** 
     * actualiza objeto t de tipo T
     */
    T update(T t);  
    
    /**
     * cuenta el numero de registros existentes en la entidad
     */
    long count();
    
}
