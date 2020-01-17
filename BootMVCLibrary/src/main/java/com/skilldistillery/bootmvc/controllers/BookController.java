package com.skilldistillery.bootmvc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.JPACrudProject.entities.Book;
import com.skilldistillery.bootmvc.data.BookDAO;

@Controller
public class BookController {
	
	@Autowired
	BookDAO dao;
	
	@RequestMapping(path="/")
	public String index() {
	  return "WEB-INF/index.jsp";
	  // return "index"; // if using a ViewResolver.
	}
	
	@RequestMapping(path = "getBook.do")
	public String showBook(@RequestParam Integer bid, HttpSession session) {
		Book book = dao.findById(bid);
		session.setAttribute("book", book);
		return "WEB-INF/book/show.jsp";
	}
	
	@RequestMapping(path = "displayUpdate.do")
	public String displayUpdatePage(HttpSession session) {
		session.setAttribute("book", session.getAttribute("book"));
		return "WEB-INF/book/update.jsp";
	}
	
	@RequestMapping(path="performUpdate.do", method=RequestMethod.POST)
	public String performUpdate(Book book, HttpSession session) {
		dao.updateBook(book);
		session.setAttribute("book", book);
		
		return "WEB-INF/book/show.jsp";
	}
	
	@RequestMapping(path="displayNew.do")
	public String displayNewPage() {
		return "WEB-INF/book/new.jsp";
	}
	
	@RequestMapping(path="createNewBook.do", method=RequestMethod.POST)
	public String performCreation(Book book, HttpSession session) {
		dao.createBook(book);
		session.setAttribute("book", book);
		
		return "WEB-INF/book/show.jsp";
	}
	
	@RequestMapping(path="deleteBook.do")
	public String performDelete(HttpSession session) {
		boolean deleted = dao.deleteBook((Book)session.getAttribute("book"));
		session.setAttribute("deleted", deleted);
		return "WEB-INF/index.jsp";
	}

}
