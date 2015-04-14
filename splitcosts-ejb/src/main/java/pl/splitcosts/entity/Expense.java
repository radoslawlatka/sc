package pl.splitcosts.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Expense extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8042701768657406302L;

	@JoinColumn(nullable=false)
	private Profile payer;

	@JoinColumn(nullable=false)
	private Profile debtor;

	@JoinColumn(nullable=false)
	private Group group;

	@Column(nullable = false) 
	private double amount;
	
	private boolean paid;
	
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date paidDate;

	public Expense() {
		paid = false;
	}
	
	public Expense(Profile payer, Profile debtor, Group group, double amount,
			String description, Date createdDate, Date paidDate) {
		this.payer = payer;
		this.debtor = debtor;
		this.group = group;
		this.amount = amount;
		this.description = description;
		this.createdDate = createdDate;
		this.paidDate = paidDate;
	}

	public Profile getPayer() {
		return payer;
	}

	public void setPayer(Profile payer) {
		this.payer = payer;
	}

	public Profile getDebtor() {
		return debtor;
	}

	public void setDebtor(Profile debtor) {
		this.debtor = debtor;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	
}
