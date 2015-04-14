package pl.splitcosts.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class InviteNotification extends Notification implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4806966730742716028L;

	private Group group;
	
	public InviteNotification() {
	}

	public InviteNotification(Profile destinationProfile, Profile creatorProfile, String description,
			boolean checked, Group group) {
		super(destinationProfile, creatorProfile, description, checked);
		this.group = group;
	}

	@Override
	public void action() {
		group.addProfile(this.destinationProfile);
		this.checked = true;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public void setDestinationProfile(Profile profile) {
		this.destinationProfile = profile;
	}
	
	
	
}
