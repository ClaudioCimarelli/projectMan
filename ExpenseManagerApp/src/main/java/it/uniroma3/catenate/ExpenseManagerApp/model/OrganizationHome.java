package it.uniroma3.catenate.ExpenseManagerApp.model;
// Generated Oct 8, 2014 12:14:12 AM by Hibernate Tools 4.0.0


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Organization.
 * @see it.uniroma3.catenate.ExpenseManagerApp.model.Organization
 * @author Hibernate Tools
 */
@Stateless
public class OrganizationHome {

    private static final Log log = LogFactory.getLog(OrganizationHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Organization transientInstance) {
        log.debug("persisting Organization instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(Organization persistentInstance) {
        log.debug("removing Organization instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public Organization merge(Organization detachedInstance) {
        log.debug("merging Organization instance");
        try {
            Organization result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Organization findById( long id) {
        log.debug("getting Organization instance with id: " + id);
        try {
            Organization instance = entityManager.find(Organization.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

