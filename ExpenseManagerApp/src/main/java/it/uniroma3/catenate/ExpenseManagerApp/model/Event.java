package it.uniroma3.catenate.ExpenseManagerApp.model;

// Generated Oct 6, 2014 12:24:29 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Event generated by hbm2java
 */
@Entity
@Table(name = "event")
@NamedQueries({ @NamedQuery(name = "findAll", query = "SELECT e FROM Event e"),
		@NamedQuery(name = "findBetweenDates", query = "SELECT e FROM Event e WHERE e.date BETWEEN :lowerDater AND :higherDater"),
		@NamedQuery(name = "findByDate", query = "SELECT e FROM Event e WHERE e.date=:date")})
public class Event implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3786553452491893586L;
	private Long id;
	private Set<Location> rentedLocations = new HashSet<Location>(0);
	private Organization organization;
	private Set<Expense> expenses = new HashSet<Expense>(0);
	private String name;
	private String notes;
	private Date date;
	private Boolean closed;
	private Integer version;

	public Event() {
	}

	public Event(Long id) {
		this.id = id;
	}

	public Event(Long id, Set<Location> rentedLocations,
			Organization organization, Set<Expense> expenses, String name,
			String notes, Date date, Boolean closed) {
		this.id = id;
		this.rentedLocations = rentedLocations;
		this.organization = organization;
		this.expenses = expenses;
		this.name = name;
		this.notes = notes;
		this.date = date;
		this.closed = closed;
	}

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id", updatable = false)
	public Set<Location> getRentedLocations() {
		return this.rentedLocations;
	}

	public void setRentedLocations(Set<Location> rentedLocations) {
		this.rentedLocations = rentedLocations;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organization_id")
	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
	public Set<Expense> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "notes")
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", unique = true, nullable = false)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "closed")
	public Boolean isClosed() {
		return this.closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	@Version
	@Column(name = "version", nullable = false)
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}

}
