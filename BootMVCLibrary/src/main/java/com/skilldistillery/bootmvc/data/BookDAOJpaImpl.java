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
	public Book createBook(Book book) {
		em.persist(book);
		return book;
	}

	@Override
	public Book findById(int id) {
		Book book = em.find(Book.class, id);
		return book;
	}
	
	@Override
	public Book updateBook(Book book) {
		
		// create managed object
		
		Book managedBook = em.find(Book.class, book.getId());
		
		// update managed object
		
		managedBook.setName(book.getName());
		managedBook.setCompleted(book.getCompleted());
		managedBook.setCheckinStatus(book.getCheckinStatus());

		return book;
	}
	
	
	@Override
	public boolean deleteBook(Book book) {
		
		// remove book from db, and if needed first turn the book into a managed object
		
		em.remove(em.contains(book) ? book : em.merge(book));
		
		// if the book is no longer in db, return true
		
		if (!em.contains(book)) {
			return true;
		} else {
			return false;
		}
	}

}
