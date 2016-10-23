package com.kordian;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.kordian.dao.UserDAO;
import com.kordian.dao.impl.UserDAOImpl;
import com.kordian.domain.User;

@ManagedBean
@ViewScoped
public class UserManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<User> userList;
	
	@PostConstruct
	public void init() {
		UserDAO userDao = new UserDAOImpl();
		userList = userDao.listUsers();
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	
}