package pl.splitcosts.entity.login;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERGROUP")
public class UserGroup implements Serializable {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 2051105090658700188L;
	
	@Id
	@Column(nullable = false, unique = true)
    private String name;
    private String description;

    @ManyToMany(mappedBy = "groups")
    private Set<User> users;
    
    public UserGroup() {
		users = new LinkedHashSet<>();
	}

	public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

	public void addToUsers(User user) {
		if(user == null) {
			throw new IllegalArgumentException("User should not be null");
		}
		users.add(user);
		user.getGroups().add(this);
	}   
}