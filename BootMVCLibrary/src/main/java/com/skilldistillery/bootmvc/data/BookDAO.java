package com.skilldistillery.bootmvc.data;

import com.skilldistillery.JPACrudProject.entities.Book;

public interface BookDAO {
	
	Book findById(int id);

}
