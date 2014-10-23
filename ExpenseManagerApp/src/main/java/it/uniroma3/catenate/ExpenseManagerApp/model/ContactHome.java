package it.uniroma3.catenate.ExpenseManagerApp.model;
// Generated Oct 8, 2014 12:14:12 AM by Hibernate Tools 4.0.0


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Contact.
 * @see it.uniroma3.catenate.ExpenseManagerApp.model.Contact
 * @author Hibernate Tools
 */
@Stateless
public class ContactHome {

    private static final Log log = LogFactory.getLog(ContactHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Contact transientInstance) {
        log.debug("persisting Contact instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(Contact persistentInstance) {
        log.debug("removing Contact instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public Contact merge(Contact detachedInstance) {
        log.debug("merging Contact instance");
        try {
            Contact result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Contact findById( long id) {
        log.debug("getting Contact instance with id: " + id);
        try {
            Contact instance = entityManager.find(Contact.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

