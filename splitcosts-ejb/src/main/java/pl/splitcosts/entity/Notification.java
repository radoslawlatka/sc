package pl.splitcosts.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public abstract class Notification extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8700296103289780362L;
	
	protected Profile destinationProfile, creatorProfile;
	protected String description;
	protected boolean checked;
	
	
	public Notification() {
		checked = false;
	}

	protected Notification(Profile destinationProfile, Profile creatorProfile, String description, boolean checked) {
		super();
		setDestinationProfile(destinationProfile);
		setCreatorProfile(creatorProfile);
		this.description = description;
		this.checked = checked;
	}

	public abstract void action();
	
	public Profile getDestinationProfile() {
		return destinationProfile;
	}

	public abstract void setDestinationProfile(Profile profile);

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Profile getCreatorProfile() {
		return creatorProfile;
	}

	public void setCreatorProfile(Profile creatorProfile) {
		this.creatorProfile = creatorProfile;
		
	}
	
	
	
}
