package pl.splitcosts.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ExpenseCategory extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7216156336877797694L;

	@Column(nullable = false)
	private String name;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
