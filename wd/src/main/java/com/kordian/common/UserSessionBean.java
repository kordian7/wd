package com.kordian.common;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserSessionBean {
	private String username;
	private long userId;
	private String selectedRole;
	
	public UserSessionBean() {
		
	}
	public UserSessionBean(String username, long userId, String selectedRole) {
		this.username = username;
		this.userId = userId;
		this.selectedRole = selectedRole;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getSelectedRole() {
		return selectedRole;
	}
	public void setSelectedRole(String selectedRole) {
		this.selectedRole = selectedRole;
	}
	
	
}
