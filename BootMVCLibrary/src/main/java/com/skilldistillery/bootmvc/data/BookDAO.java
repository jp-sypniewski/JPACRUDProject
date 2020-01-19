package com.skilldistillery.bootmvc.data;

import com.skilldistillery.JPACrudProject.entities.Book;

public interface BookDAO {
	
	Book createBook(Book book);
	Book findById(int id);
	Book updateBook(Book book);
	boolean deleteBook(Book book);

}
