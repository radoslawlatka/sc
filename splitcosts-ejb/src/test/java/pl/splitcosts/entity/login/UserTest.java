package pl.splitcosts.entity.login;

import static org.fest.assertions.Assertions.*;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private User user;
	
	@Before
	public void setUp() throws Exception {
		user = new User();
		user.setEmail("email@email.pl");
		user.setPassword("pass");
	}

	@Test
	public void testInit() {
		assertThat(user.getGroups())
			.isNotNull()
			.isEmpty();
	}
	
	@Test
	public void testAddToGroup() {
		UserGroup userGroup = new UserGroup();
		userGroup.setName("userGroup");
		
		user.addToGroup(userGroup);
		
		assertThat(user.getGroups())
			.isNotNull()
			.isNotEmpty()
			.hasSize(1)
			.contains(userGroup);
		
		assertThat(userGroup.getUsers())
			.isNotNull()
			.isNotEmpty()
			.hasSize(1)
			.contains(user);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNullToGroups() {
		user.addToGroup(null);
	}

}
