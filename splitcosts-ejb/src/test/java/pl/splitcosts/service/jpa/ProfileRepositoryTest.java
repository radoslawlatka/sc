package pl.splitcosts.service.jpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import pl.splitcosts.entity.Expense;
import pl.splitcosts.entity.ExpenseCategory;
import pl.splitcosts.entity.Group;
import pl.splitcosts.entity.Notification;
import pl.splitcosts.entity.Profile;

public class ProfileRepositoryTest {

	private ProfileRepository repository;
	private EntityManager em;
	private Profile profile;
	
	@Before
	public void setUp() throws Exception {
		profile = new Profile("email@email.pl", "", "", "", new LinkedHashSet<Group>(), new ArrayList<Notification>());
		
		em = mock(EntityManager.class);
		repository = new ProfileRepository();
		repository.setEm(em);
		
	}

	@Test
	public void testFindProfileByEmail() {
		TypedQuery<Profile> typedQuery = mock(TypedQuery.class);
		
		when(typedQuery.setParameter(anyString(), any())).thenReturn(typedQuery);
		when(typedQuery.getSingleResult()).thenReturn(profile);
		when(em.createQuery(anyString(), eq(Profile.class))).thenReturn(typedQuery);

		Profile result = repository.findByEmail("email@email.pl");
		
		verify(em, times(1)).createQuery("SELECT p FROM Profile p WHERE p.email=:email", Profile.class);
		verify(typedQuery, times(1)).setParameter("email", "email@email.pl");
		verify(typedQuery, times(1)).getSingleResult();
		
		assertNotNull(result);
	}
	
	@Test
	public void testFindProfileByEmailWhenProfileDoesNotExist() {
		TypedQuery<Profile> typedQuery = mock(TypedQuery.class);
		
		when(typedQuery.setParameter(anyString(), any())).thenReturn(typedQuery);
		doThrow(new NoResultException()).when(typedQuery).getSingleResult();
		when(em.createQuery(anyString(), eq(Profile.class))).thenReturn(typedQuery);
		
		Profile result = repository.findByEmail("email@email.pl");
		
		verify(em, times(1)).createQuery("SELECT p FROM Profile p WHERE p.email=:email", Profile.class);
		verify(typedQuery, times(1)).setParameter("email", "email@email.pl");
		verify(typedQuery, times(1)).getSingleResult();
		
		assertNull(result);
	}
	

	
	
	
	
	
	
	
	

}
