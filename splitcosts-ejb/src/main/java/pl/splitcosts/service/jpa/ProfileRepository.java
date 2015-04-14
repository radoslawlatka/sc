package pl.splitcosts.service.jpa;

import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;

import pl.splitcosts.entity.Profile;

public class ProfileRepository extends GenericRepository<Profile> {

	private static final Logger Log = Logger.getLogger(ProfileRepository.class);
	
	public ProfileRepository() {
		super(Profile.class);
	}

	public Profile findByEmail(String email) {
		Log.info("Find profile by email");
		try {
			
			return em.createQuery("SELECT p " 
						+ "FROM " + Profile.class.getSimpleName() + " p "
						+ "WHERE p.email=:email", Profile.class)
						.setParameter("email", email)
						.getSingleResult();
			
		} catch(NoResultException e) {
			Log.warn("Profile with email: " + email + " does not exist");
			return null;
		}
	}

	public List<Profile> findAllByGroupId(long groupId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
