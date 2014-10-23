package it.uniroma3.catenate.ExpenseManagerApp.model;

// Generated Oct 8, 2014 12:14:12 AM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalHome;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Event.
 * 
 * @see it.uniroma3.catenate.ExpenseManagerApp.model.Event
 * @author Hibernate Tools
 */
@Stateless(name="eventRepo")
public class EventHome {

	private static final Log log = LogFactory.getLog(EventHome.class);

	@PersistenceContext(name="primary")
	private EntityManager entityManager;

	public void persist(Event transientInstance) {
		log.debug("persisting Event instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Event persistentInstance) {
		log.debug("removing Event instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Event merge(Event detachedInstance) {
		log.debug("merging Event instance");
		try {
			Event result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Event findById(long id) {
		log.debug("getting Event instance with id: " + id);
		try {
			Event instance = entityManager.find(Event.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Event> findAll() {
		try {
			List<Event> events = entityManager.createNamedQuery("findAll", Event.class)
					.getResultList();
			return events;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Event> findBetweenDates(Date lower, Date higher) {
		try {
			List<Event> events = entityManager
					.createNamedQuery("findBetweenDates", Event.class)
					.setParameter("lowerDate", lower)
					.setParameter("higherDate", higher).getResultList();
			return events;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
