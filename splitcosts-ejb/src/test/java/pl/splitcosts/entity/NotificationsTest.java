package pl.splitcosts.entity;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import org.junit.Before;
import org.junit.Test;

public class NotificationsTest {

	private RemindNotification remindNotification;
	//private Notification notification;
	private InviteNotification inviteNotification;
	private Profile profile, creatorProfile;
	private Group group;
	
	@Before
	public void setUp() {
		profile = new Profile("email", "firstName", "lastName", "", new LinkedHashSet<>(), new ArrayList<>());
		creatorProfile = new Profile("payer", "Payer", "Payer", "", new LinkedHashSet<>(), new ArrayList<>());
		group = new Group();
		group.setId(1L);
		group.setName("");
		
		remindNotification = new RemindNotification(profile, creatorProfile, "remindDesc", false);
		inviteNotification = new InviteNotification(profile, creatorProfile, "invite", false, group);
		
		profile.addNotification(remindNotification);
		profile.addNotification(inviteNotification);
	}
	
	@Test
	public void testInit() {
		
		assertThat(profile.getNotifications())
			.isNotNull()
			.isNotEmpty()
			.hasSize(2)
			.contains(remindNotification, inviteNotification);
	}
	
	@Test
	public void testActionInvite() {
		assertThat(group.getProfiles())
			.excludes(profile);
		
		inviteNotification.action();
		
		assertThat(group.getProfiles())
			.contains(profile);
	}
	

}
