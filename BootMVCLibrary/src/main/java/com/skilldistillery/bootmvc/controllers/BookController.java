package com.skilldistillery.bootmvc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String showBook(@RequestParam Integer bid, Model model) {
		Book book = dao.findById(bid);
		model.addAttribute("book", book);
		return "WEB-INF/book/show.jsp";
	}
	
	@RequestMapping(path = "displayUpdate.do")
	public String displayUpdatePage(HttpSession session) {
		session.setAttribute("book", session.getAttribute("book"));
		
		return "WEB-INF/book/update.jsp";
	}

}
