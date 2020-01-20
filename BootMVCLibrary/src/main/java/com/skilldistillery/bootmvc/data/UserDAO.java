package com.skilldistillery.bootmvc.data;

import com.skilldistillery.JPACrudProject.entities.User;

public interface UserDAO {

	User getUserByLogin(String username, String password);

}
