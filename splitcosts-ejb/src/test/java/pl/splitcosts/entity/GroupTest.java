package pl.splitcosts.entity;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class GroupTest {

	private Group group;
	
	@Before
	public void setUp() throws Exception {
		group = new Group();
		group.setId(1L);
		group.setName("group");
		group.setDesription("description");
	}
	
	@Test
	public void initTest() {
		assertThat(group.getProfiles())
			.isNotNull()
			.isEmpty();
		
		assertThat(group.getExpenses())
			.isNotNull()
			.isEmpty();
			
			assertThat(group.getExpenseCategories())
			.isNotNull()
			.isEmpty();
	}

	@Test
	public void testAddProfile() {
		Profile profile = new Profile("email@p.pl", "", "", "", null, null);
		
		group.addProfile(profile);
		
		assertThat(group.getProfiles())
			.isNotNull()
			.isNotEmpty()
			.hasSize(1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNullToProfiles() {
		group.addProfile(null);
	}
	
	@Test
	public void testIsFlatShouldReturnFalse() {
		assertFalse(group.isFlat());
	}
	
	@Test
	public void testAddExpense() {
		Expense e = new Expense(new Profile(), new Profile(), null, 10, "", new Date(), new Date());
		e.setId(1L);
		
		group.addExpense(e);
		
		assertThat(group.getExpenses())
			.isNotNull()
			.isNotEmpty()
			.hasSize(1)
			.contains(e);
		
		assertThat(e.getGroup())
			.isNotNull()
			.isEqualTo(group);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNullToExpenses() {
		group.addExpense(null);
	}
	
	@Test
	public void testAddExpenseCategory() {
		ExpenseCategory expenseCat = new ExpenseCategory();
		expenseCat.setId(1L);
		expenseCat.setName("category");
		
		group.addExpenseCategory(expenseCat);
		
		assertThat(group.getExpenseCategories())
		.isNotNull()
		.isNotEmpty()
		.hasSize(1)
		.contains(expenseCat);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNullToExpenseCategory() {
		group.addExpenseCategory(null);
	}

}
