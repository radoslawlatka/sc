package pl.splitcosts.entity.login;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS") //User is a reserved word
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 812542353052028791L;

	@Id
	@Column(nullable = false, unique = true, updatable = false)
    private String email;
    
    @Column(nullable = false)
    private String password;
   
    @ManyToMany
    @JoinTable(
            name = "USERS_USERGROUPS", 
            joinColumns = { @JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL") }, 
            inverseJoinColumns = { @JoinColumn(name = "GROUPNAME", referencedColumnName = "NAME") })
    private List<UserGroup> groups;

    public User() {
        groups = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<UserGroup> groups) {
        this.groups = groups;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
                return true;
        if (!(obj instanceof User))
                return false;
        User other = (User) obj;
        return (this.email == null ? other.email == null : email.equals(other.email));
    }

	public void addToGroup(UserGroup userGroup) {
		if(userGroup == null) {
			throw new IllegalArgumentException("UserGroup should not be null");
		}
		groups.add(userGroup);
		userGroup.getUsers().add(this);
	}
    
}
