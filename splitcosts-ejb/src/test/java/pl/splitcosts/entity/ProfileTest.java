package pl.splitcosts.entity;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProfileTest {

	private Profile profile;
	
	@Before
	public void setUp() throws Exception {
		profile = new Profile();
		profile.setId(1L);
		profile.setEmail("email@email.pl");
		profile.setFirstName("firstName");
		profile.setLastName("lastName");
		profile.setAvatar("");

	}

	@Test
	public void failedTest1() throws Exception {
		assertTrue(false);
	}

	@Test
	public void failedTest2() throws Exception {
		assertTrue(false);
	}
	
	@Test
	public void testInit() {
		assertThat(profile.getGroups())
			.isNotNull()
			.isEmpty();
		
		assertThat(profile.getNotifications())
			.isNotNull()
			.isEmpty();

	}
	
	@Test
	public void testAddToGroup() {
		Group group = new Group();
		group.setId(1L);
		group.setName("group");

		profile.addToGroup(group);
		
		assertThat(profile.getGroups())
			.isNotNull()
			.isNotEmpty()
			.hasSize(1)
			.contains(group);
		
		assertThat(group.getProfiles())
			.isNotNull()
			.isNotEmpty()
			.hasSize(1)
			.contains(profile);
	}
	
	
	@Test
	public void testAdditionMoreGroups() {
		Group group1 = new Group();
		group1.setId(1L);
		group1.setName("group1");
		Group group2 = new Group();
		group2.setId(2L);
		group2.setName("group2");
		
		profile.addToGroup(group1);
		profile.addToGroup(group2);
		
		assertThat(profile.getGroups())
		.isNotNull()
		.isNotEmpty()
		.hasSize(2)
		.contains(group1, group2);
				
		assertThat(group1.getProfiles())
		.isNotNull()
		.isNotEmpty()
		.hasSize(1)
		.contains(profile);
		
		assertThat(group2.getProfiles())
		.isNotNull()
		.isNotEmpty()
		.hasSize(1)
		.contains(profile);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNullToGroup() {
		profile.addToGroup(null);
	}
	
	@Test
	public void testAddRemindNotification() {
		RemindNotification remindNotification = new RemindNotification();
		remindNotification.setId(1L);
		
		profile.addNotification(remindNotification);
		
		assertThat(profile.getNotifications())
			.isNotNull()
			.isNotEmpty()
			.hasSize(1)
			.contains(remindNotification);
		
		assertThat(remindNotification.getDestinationProfile())
			.isNotNull()
			.isEqualTo(profile);
	}
	
	@Test
	public void testAddInviteNotification() {
		InviteNotification inviteNotification = new InviteNotification();
		inviteNotification.setId(2L);
		
		profile.addNotification(inviteNotification);
		
		assertThat(profile.getNotifications())
		.isNotNull()
		.isNotEmpty()
		.hasSize(1)
		.contains(inviteNotification);
		
		assertThat(inviteNotification.getDestinationProfile())
		.isNotNull()
		.isEqualTo(profile);
	}
	
	@Test
	public void testAdditionMoreThanOneNOtdications() {
		InviteNotification inviteNotification = new InviteNotification();
		inviteNotification.setId(1L);
		
		RemindNotification remindNotification1 = new RemindNotification();
		remindNotification1.setId(2L);
		
		RemindNotification remindNotification2 = new RemindNotification();
		remindNotification2.setId(3L);
		
		profile.addNotification(inviteNotification);
		profile.addNotification(remindNotification1);
		profile.addNotification(remindNotification2);
		
		assertThat(profile.getNotifications())
		.isNotNull()
		.isNotEmpty()
		.hasSize(3)
		.contains(inviteNotification,remindNotification1,remindNotification2);
		
		assertThat(inviteNotification.getDestinationProfile())
		.isNotNull()
		.isEqualTo(profile);
		
		assertThat(remindNotification1.getDestinationProfile())
		.isNotNull()
		.isEqualTo(profile);
		
		assertThat(remindNotification2.getDestinationProfile())
		.isNotNull()
		.isEqualTo(profile);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNullToNotification() {
		profile.addNotification(null);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
