package com.kordian.dao;

import java.util.List;

import com.kordian.domain.User;

public interface UserDAO {
	public List<User> listUsers();
	
	public boolean validate(String username, String hashedPwd);
}
