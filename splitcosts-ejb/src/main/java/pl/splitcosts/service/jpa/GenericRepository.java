package pl.splitcosts.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericRepository<T> {

    @PersistenceContext(unitName = "splitcosts-pu")
    protected EntityManager em;

    private Class<T> type;

    /**
     * Default constructor
     * 
     * @param type entity class
     */
    public GenericRepository(Class<T> type) {
        this.type = type;
    }

    public GenericRepository(Class<T> type, EntityManager em) {
        this(type);
        this.em = em;
    }
    
    /**
     * Stores an instance of the entity class in the database
     * @param T Object
     * @return 
     */
    public T create(T t) {
        this.em.persist(t);
        this.em.flush();
        this.em.refresh(t);
        return t;
    }

    /**
     * Retrieves an entity instance that was previously persisted to the database 
     * @param id
     * @return 
     */
    public T find(Object id) {
        return this.em.find(this.type, id);
    }
    
    /**
     * Retrieves a list of instances that was previously persisted to the database
     * @return List
     */
    public List<T> findAll() {
        return this.em.createQuery("SELECT t FROM " + type.getName() + " t", type).getResultList();
    }

    /**
     * Removes the record that is associated with the entity instance
     * @param type
     * @param id 
     */
    public void delete(T item) {
        T merged = em.merge(item);
        em.remove(merged);
    }

    /**
     * Updates the entity instance
     * @param <T>
     * @param t
     * @return the object that is updated
     */
    public T update(T item) {
        return (T) this.em.merge(item);
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
