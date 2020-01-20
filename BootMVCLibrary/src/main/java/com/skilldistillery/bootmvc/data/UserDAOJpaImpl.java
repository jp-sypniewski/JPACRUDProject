package com.skilldistillery.bootmvc.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.JPACrudProject.entities.User;


@Transactional
@Service
public class UserDAOJpaImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public User getUserByLogin(String username, String password) {
		User user = null;
		
		String jpql = "select user from User user where username = :username"
				+ " and password = :password";
		
		user = em.createQuery(jpql, User.class).setParameter("username", username)
				.setParameter("password", password).getResultList().get(0);
				
		
		
		return user;
	}
	
	
	
	
//	public static void main(String[] args) throws NoSuchAlgorithmException {
//		String password = "password";		
//		MessageDigest md  = MessageDigest.getInstance("MD5");
//		
//	    md.update(password.getBytes());
//	    byte[] digest = md.digest();
//	    String myHash = DatatypeConverter
//	      .printHexBinary(digest).toUpperCase();
//	    
//	    System.out.println("Hashed password: " + myHash);
//		
//		
//	}

}
