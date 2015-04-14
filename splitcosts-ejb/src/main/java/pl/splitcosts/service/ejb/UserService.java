package pl.splitcosts.service.ejb;

import pl.splitcosts.entity.login.User;
import pl.splitcosts.service.ejb.exception.ModifyPasswordException;
import pl.splitcosts.service.ejb.exception.UserException;

public interface UserService {

	public User signupUser(User user) throws UserException;
	
	public void modifyPassword(String newPassword) throws ModifyPasswordException; 
	
	public void deleteUserAccount() throws UserException;
	
}
