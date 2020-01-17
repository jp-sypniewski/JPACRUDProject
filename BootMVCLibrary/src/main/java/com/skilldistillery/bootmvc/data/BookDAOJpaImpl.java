package com.skilldistillery.bootmvc.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.JPACrudProject.entities.Book;

@Transactional
@Service
public class BookDAOJpaImpl implements BookDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Book findById(int id) {
		Book book = em.find(Book.class, id);
		return book;
	}

}
