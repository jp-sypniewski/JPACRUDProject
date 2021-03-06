package com.skilldistillery.bootmvc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.JPACrudProject.entities.Book;
import com.skilldistillery.JPACrudProject.entities.User;
import com.skilldistillery.bootmvc.data.BookDAO;
import com.skilldistillery.bootmvc.data.UserDAO;

@Controller
public class BookController {
	
	@Autowired
	BookDAO dao;
	@Autowired
	UserDAO userdao;
	
	@RequestMapping(path= {"/", "index.do"})
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
	
	@RequestMapping(path="switchCompletionStatus.do")
	public String switchCompletionStatus(HttpSession session) {
		Book sessionBook = (Book) session.getAttribute("book");
		sessionBook.setCompleted(!sessionBook.getCompleted());
		dao.updateBook(sessionBook);
		session.removeAttribute("book");
		session.setAttribute("book", sessionBook);
		return "WEB-INF/book/show.jsp";
	}
	
	@RequestMapping(path="reserveBook.do")
	public String reserveBook(HttpSession session) {
		Book sessionBook = (Book) session.getAttribute("book");
		sessionBook.setCheckinStatus("reserved");
		dao.updateBook(sessionBook);
		session.removeAttribute("book");
		session.setAttribute("book", sessionBook);
		return "WEB-INF/book/show.jsp";
	}
	
	@RequestMapping(path="checkBookOut.do")
	public String checkBookOut(HttpSession session) {
		Book sessionBook = (Book) session.getAttribute("book");
		sessionBook.setCheckinStatus("out");
		dao.updateBook(sessionBook);
		session.removeAttribute("book");
		session.setAttribute("book", sessionBook);
		return "WEB-INF/book/show.jsp";
	}
	
	@RequestMapping(path="makeBookAvail.do")
	public String makeBookAvail(HttpSession session) {
		Book sessionBook = (Book) session.getAttribute("book");
		sessionBook.setCheckinStatus("avail");
		dao.updateBook(sessionBook);
		session.removeAttribute("book");
		session.setAttribute("book", sessionBook);
		return "WEB-INF/book/show.jsp";
	}
	
	@RequestMapping(path="showLogin.do")
	public String showLogin(HttpSession session, Model model) {
		
		
		if (session.getAttribute("user") != null) {
			return "WEB-INF/index.jsp";
		} else {
			model.addAttribute("user", new User());
			return "WEB-INF/book/login.jsp";
		}
		
	}
	
	@RequestMapping(path="login.do", method=RequestMethod.POST)
	public String logUserIn(User user, HttpSession session) {
		User loggedInUser = userdao.getUserByLogin(user.getUsername(), user.getPassword());
		
		if(loggedInUser != null) {
			session.setAttribute("user", loggedInUser);
		}
		
		return "redirect:index.do";
	}
	

}
