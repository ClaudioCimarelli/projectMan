package it.uniroma3.catenate.ExpenseManagerApp.model;
// Generated Oct 8, 2014 12:14:12 AM by Hibernate Tools 4.0.0


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Expense.
 * @see it.uniroma3.catenate.ExpenseManagerApp.model.Expense
 * @author Hibernate Tools
 */
@Stateless
public class ExpenseHome {

    private static final Log log = LogFactory.getLog(ExpenseHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Expense transientInstance) {
        log.debug("persisting Expense instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(Expense persistentInstance) {
        log.debug("removing Expense instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public Expense merge(Expense detachedInstance) {
        log.debug("merging Expense instance");
        try {
            Expense result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Expense findById( long id) {
        log.debug("getting Expense instance with id: " + id);
        try {
            Expense instance = entityManager.find(Expense.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

