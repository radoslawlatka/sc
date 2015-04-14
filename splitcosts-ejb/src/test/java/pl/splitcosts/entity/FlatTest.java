package pl.splitcosts.entity;


import static org.fest.assertions.Assertions.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class FlatTest {

	private Flat flat;
	
	@Before
	public void setUp() throws Exception {
		flat = new Flat();
		flat.setId(1L);
		flat.setCity("");
		flat.setStreet("");
		flat.setName("flat");
	}

	@Test
	public void testInit() {
		assertThat(flat.getProfiles())
			.isNotNull()
			.isEmpty();
	}
	
	@Test
	public void testAddProfile() {
		Profile p = new Profile("email", "fn", "ln", "", null, null);
		
		flat.addProfile(p);
		
		assertThat(flat.getProfiles())
			.isNotNull()
			.isNotEmpty()
			.hasSize(1)
			.contains(p);
	}
	
	@Test
	public void testAdditionMoreProfiles() {
		Profile p1 = new Profile("email", "fn", "ln", "", null, null);
		Profile p2 = new Profile("email", "fn", "ln", "", null, null);
		Profile p3 = new Profile("email", "fn", "ln", "", null, null);
		
		flat.addProfile(p1);
		flat.addProfile(p2);
		flat.addProfile(p3);
		
		assertThat(flat.getProfiles())
		.isNotNull()
		.isNotEmpty()
		.hasSize(3)
		.contains(p1, p2, p3);
	}
	
	@Test
	public void testAdditionTheSamoProfile() {
		Profile p1 = new Profile("email", "fn", "ln", "", null, null);
		
		flat.addProfile(p1);
		flat.addProfile(p1);
		flat.addProfile(p1);
		
		assertThat(flat.getProfiles())
		.isNotNull()
		.isNotEmpty()
		.hasSize(1)
		.contains(p1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNullToProfiles() {		
		flat.addProfile(null);
	}
	
	@Test
	public void testAddExpense() {
		Expense e = new Expense(new Profile(), new Profile(), null, 10, "", new Date(), new Date());
		e.setId(1L);
		
		flat.addExpense(e);
		
		assertThat(flat.getExpenses())
			.isNotNull()
			.isNotEmpty()
			.hasSize(1)
			.contains(e);
		
		assertThat(e.getGroup())
			.isNotNull()
			.isEqualTo(flat);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNullToExpenses() {
		flat.addExpense(null);
	}
	
	
	@Test
	public void testAddExpenseCategory() {
		ExpenseCategory expenseCat = new ExpenseCategory();
		expenseCat.setId(1L);
		expenseCat.setName("category");
		
		flat.addExpenseCategory(expenseCat);
		
		assertThat(flat.getExpenseCategories())
		.isNotNull()
		.isNotEmpty()
		.hasSize(1)
		.contains(expenseCat);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNullToExpenseCategory() {
		flat.addExpenseCategory(null);
	}

}
