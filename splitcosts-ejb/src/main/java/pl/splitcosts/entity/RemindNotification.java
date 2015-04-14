package pl.splitcosts.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class RemindNotification extends Notification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2474339561292614154L;	
	
	public RemindNotification() {
		super();
	}

	public RemindNotification(Profile destinationProfile, Profile creatorProfile, String description,
			boolean checked) {
		super(destinationProfile, creatorProfile, description, checked);
	}

	public void action() {
		
	}

	@Override
	public void setDestinationProfile(Profile profile) {
		this.destinationProfile = profile;
	}
	
	
}
