package pl.splitcosts.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Profile extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5701838028535747119L;

	@Column(nullable = false, unique = true, updatable = false)
	private String email;
	
	private String firstName;
	
	private String lastName;	
	
	private String avatar;
	
    @ManyToMany
    @JoinTable(
            name = "PROFILES_GROUPS", 
            joinColumns = { @JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL") }, 
            inverseJoinColumns = { @JoinColumn(name = "GROUP_NAME", referencedColumnName = "NAME") })
	private Set<Group> groups;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Notification> notifications;

	public Profile() {
		this.groups = new LinkedHashSet<>();
		this.notifications = new ArrayList<>();
	}

	public Profile(String email, String firstName, String lastName,
			String avatar, Set<Group> groups,
			List<Notification> notifications) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.avatar = avatar;
		this.groups = groups;
		this.notifications = notifications;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public void addToGroup(Group group) {
		if(group == null) {
			throw new IllegalArgumentException("Group should not be null");
		}
		groups.add(group);
		group.getProfiles().add(this);
	}

	public void addNotification(Notification notification) {
		if(notification == null) {
			throw new IllegalArgumentException("Notification should not be null");
		}
		notifications.add(notification);
		notification.setDestinationProfile(this);
	}
 
}
