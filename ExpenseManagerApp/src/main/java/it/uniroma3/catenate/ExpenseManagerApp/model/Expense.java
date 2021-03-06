package it.uniroma3.catenate.ExpenseManagerApp.model;

// Generated Oct 6, 2014 12:24:29 PM by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Expense generated by hbm2java
 */
@Entity
@Table(name = "expense")
public class Expense implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6619036561404422082L;
	private Long id;
	private Integer quantity;
	private Money unitAmount;
	private Money payedAmount;
	private Money totalAmount;
	private String notes;
	private Boolean payed;
	private Event event;
	private SubCategory subCategory;
	private Integer version;

	public Expense() {
	}

	public Expense(Long id) {
		this.id = id;
	}

	public Expense(Long id, Integer quantity, Money unitAmount, Money payedAmount,
			String notes, Boolean payed, Money totalAmount,
			SubCategory subCategory, Event event) {
		this.id = id;
		this.quantity = quantity;
		this.unitAmount = unitAmount;
		this.payedAmount = payedAmount;
		this.notes = notes;
		this.payed = payed;
		this.totalAmount = totalAmount;
		this.subCategory = subCategory;
		this.event = event;
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

	@Column(name = "quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Embedded
	@AttributeOverrides(@AttributeOverride(name = "amount", column = @Column(name = "unit_amount")))
	public Money getUnitAmount() {
		return unitAmount;
	}

	public void setUnitAmount(Money unitAmount) {
		this.unitAmount = unitAmount;
	}

	@Embedded
	@AttributeOverrides(@AttributeOverride(name = "amount", column = @Column(name = "payed_amount")))
	public Money getPayedAmount() {
		return payedAmount;
	}

	public void setPayedAmount(Money payedAmount) {
		this.payedAmount = payedAmount;
	}

	@Embedded
	@AttributeOverrides(@AttributeOverride(name = "amount", column = @Column(name = "total_amount")))
	public Money getTotalAmount() {
		return totalAmount;
	}

	protected void setTotalAmount(Money totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column(name = "notes")
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "payed")
	public Boolean isPayed() {
		return this.payed;
	}

	public void setPayed(Boolean payed) {
		this.payed = payed;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id",nullable=false,updatable=false)
	protected Event getEvent() {
		return event;
	}

	protected void setEvent(Event event) {
		this.event = event;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subcategory_id")
	public SubCategory getSubCategory() {
		return this.subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
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
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result
				+ ((subCategory == null) ? 0 : subCategory.hashCode());
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
		Expense other = (Expense) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (subCategory == null) {
			if (other.subCategory != null)
				return false;
		} else if (!subCategory.equals(other.subCategory))
			return false;
		return true;
	}

}
