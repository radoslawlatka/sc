package pl.splitcosts.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Flat extends Group implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1964651773371219859L;
	
    
    private String street;
    
    private String number;
    
    private String city;
    
	public Flat() {
		super();
	}

	public Flat(String name, String desription, Set<Profile> profiles, List<Expense> expenses, List<ExpenseCategory> expenseCategories, String street, String number, String city) {
		super(name, desription, profiles, expenses, expenseCategories);
		this.street = street;
		this.number = number;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public boolean isFlat() {
		return true;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}    
	
	
}
