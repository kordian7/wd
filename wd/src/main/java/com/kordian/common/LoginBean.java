package com.kordian.common;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.kordian.dao.UserDAO;
import com.kordian.dao.impl.UserDAOImpl;
import com.kordian.utils.SessionUtil;

@ManagedBean
@SessionScoped
public class LoginBean {
	private static final long serialVersionUID = 1L;
	
	// TODO - injecty
	UserDAO userDao = new UserDAOImpl();
	
	private String username;
	private String password;
	private String userrole;
	
	
	public String login() {
		boolean validateResult = userDao.validate(username, password /* TODO - !!! HASHOWANIE tutaj*/);
		if(validateResult) {
			HttpSession session = SessionUtil.getSession();
			session.setAttribute("username", username);
			// TODO - session.setAttribute("userid", userid);
			// TODO - session.setAttribute("userrole", userrole);
			
			return "home?faces-redirect=true";
		} else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
 
            // invalidate session, and redirect to other pages
 
            //message = "Invalid Login. Please Try Again!";
            return "login?faces-redirect=true";
        }
	}
	
	public String logout() {
		HttpSession session = SessionUtil.getSession();
		session.invalidate();
		return "login?faces-redirect=true";
	}
	
	// getters and setters
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
}
