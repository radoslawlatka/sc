package pl.splitcosts.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.splitcosts.entity.Group;

@Singleton
@Startup
public class SingletonStartup {

	@PersistenceContext
	private EntityManager em;

	public SingletonStartup() {
				
	}
	
	@PostConstruct
	public void init() {
		Group g = new Group( );
		em.persist(g );
	}
	
	
	
}
