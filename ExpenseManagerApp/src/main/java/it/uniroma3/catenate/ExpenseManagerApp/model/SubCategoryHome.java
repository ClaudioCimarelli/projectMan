package it.uniroma3.catenate.ExpenseManagerApp.model;
// Generated Oct 8, 2014 12:14:12 AM by Hibernate Tools 4.0.0


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class SubCategory.
 * @see it.uniroma3.catenate.ExpenseManagerApp.model.SubCategory
 * @author Hibernate Tools
 */
@Stateless
public class SubCategoryHome {

    private static final Log log = LogFactory.getLog(SubCategoryHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(SubCategory transientInstance) {
        log.debug("persisting SubCategory instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(SubCategory persistentInstance) {
        log.debug("removing SubCategory instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public SubCategory merge(SubCategory detachedInstance) {
        log.debug("merging SubCategory instance");
        try {
            SubCategory result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public SubCategory findById( int id) {
        log.debug("getting SubCategory instance with id: " + id);
        try {
            SubCategory instance = entityManager.find(SubCategory.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

