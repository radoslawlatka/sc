package pl.splitcosts.service.jpa;

import javax.ejb.Stateless;

import pl.splitcosts.entity.login.UserGroup;

@Stateless
public class UserGroupRepository extends GenericRepository<UserGroup> {

	public UserGroupRepository() {
		super(UserGroup.class);
	}

}
