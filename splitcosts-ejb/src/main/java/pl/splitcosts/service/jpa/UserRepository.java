package pl.splitcosts.service.jpa;

import javax.ejb.Stateless;

import pl.splitcosts.entity.login.User;

@Stateless
public class UserRepository extends GenericRepository<User> {

	public UserRepository() {
		super(User.class);
	}

}
