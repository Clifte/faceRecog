package br.com.facerecognition.entity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateless
public class GenericServiceBean implements GenericService{

	@PersistenceContext(unitName="UNMVMCARD_PU", type=PersistenceContextType.EXTENDED)
    private EntityManager em;

	public GenericServiceBean() {
		System.out.println("Creating DAOA");
	}
	@Override
	public <T> T createOrUpdate(T obj) {
		em.merge(obj); 
		return null; 
	}

	@Override
	public <T> void remove(T obj) {
		em.remove(obj);	
	}

	@Override
	public <T> T find(Object obj) {
		return null;
	}

	
}
