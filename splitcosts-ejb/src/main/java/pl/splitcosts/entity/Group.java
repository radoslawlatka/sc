package pl.splitcosts.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@MappedSuperclass
@Table(name = "GROUPS")
public class Group extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6704393064692626970L;

	@Column(nullable = false, updatable = false)
	protected String name;
	
	protected String desription; 
	
    @ManyToMany(mappedBy = "groups")
    protected Set<Profile> profiles;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Expense> expenses;    
    
    private List<ExpenseCategory> expenseCategories;
    
	public Group() {
		profiles = new LinkedHashSet<>();
		expenses = new ArrayList<>();
		expenseCategories = new ArrayList<>();
	}

	public Group(String name, String desription, Set<Profile> profiles, List<Expense> expenses, List<ExpenseCategory> expenseCategories) {
		super();
		this.name = name;
		this.desription = desription;
		this.profiles = profiles;
		this.expenses = expenses;
		this.expenseCategories = expenseCategories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}

	public Set<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}
	
	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
	
	public List<ExpenseCategory> getExpenseCategories() {
		return expenseCategories;
	}

	public void setExpenseCategories(List<ExpenseCategory> expenseCategories) {
		this.expenseCategories = expenseCategories;
	}

	public void addProfile(Profile profile) {
		if(profile == null) {
			throw new IllegalArgumentException("Profile should not be null");
		}
		this.profiles.add(profile);
	}
	
	public boolean isFlat() {
		return false;
	}

	public void addExpense(Expense expense) {
		if(expense == null) {
			throw new IllegalArgumentException("Expense should not be null");
		}
		expenses.add(expense);
		expense.setGroup(this);		
	}

	public void addExpenseCategory(ExpenseCategory expenseCategory) {
		if(expenseCategory == null) {
			throw new IllegalArgumentException("Expense should not be null");
		}
		expenseCategories.add(expenseCategory);
	}
	
}
