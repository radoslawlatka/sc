package pl.splitcosts.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;

import org.junit.Before;
import org.junit.Test;

public class ExpenseTest {

	private Expense expense;
	private Profile payer, debtor;
	private Group group;
	private double amount;
	
	@Before
	public void setUp() {
		payer = new Profile("email1", "", "", "", new LinkedHashSet<>(), new ArrayList<>());
		debtor = new Profile("email2", "", "", "", new LinkedHashSet<>(), new ArrayList<>());
		group = new Group();
		amount = 10.5;
		
		expense = new Expense(payer, debtor, group, amount, "desc", new Date(), null);
	}
	
	@Test
	public void test() {
		
	}

}
