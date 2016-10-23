package com.kordian.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kordian.dao.UserDAO;
import com.kordian.domain.User;
import com.kordian.utils.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
    @SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<User> userList = session.createQuery("from User").list();
		for(User us: userList)
			logger.info("Users: " + us);
		session.getTransaction().commit();
		return userList;
	}

	@Override
	public boolean validate(String username, String hashedPwd) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where username=:username and hashed_pwd=:hashed_pwd");
		query.setParameter("username", username);
		query.setParameter("hashed_pwd", hashedPwd);
		List<User> userList = query.list();
		for(User us: userList)
			logger.info("Users: " + us);
		session.getTransaction().commit();
		if(userList.size() == 1)
			return true;
		else return false;
		
	}

    
}
