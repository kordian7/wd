package com.kordian.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

}
