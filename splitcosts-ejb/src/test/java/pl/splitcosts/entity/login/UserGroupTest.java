package pl.splitcosts.entity.login;

import static org.fest.assertions.Assertions.*;
import org.junit.Before;
import org.junit.Test;

public class UserGroupTest {

	private UserGroup userGroup;
	
	@Before
	public void setUp() throws Exception {
		userGroup = new UserGroup();
		userGroup.setName("users");
		userGroup.setDescription("");
	}

	@Test
	public void testInit() {
		assertThat(userGroup.getUsers())
			.isNotNull()
			.isEmpty();
	}
	
	@Test
	public void testAdditionUser() {
		User u = new User();
		u.setEmail("email");
		u.setPassword("pass");
		
		userGroup.addToUsers(u);
		
		assertThat(userGroup.getUsers())
			.isNotNull()
			.isNotEmpty()
			.hasSize(1)
			.contains(u);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAdditionNullToUsers() {
		userGroup.addToUsers(null);
	}
	
}
