package com.ttnd.linksharing.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttnd.linksharing.dao.CommonDao;
import com.ttnd.linksharing.entity.User;

@Repository
public class UserDaoImp implements CommonDao<User> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User get(Integer id) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
		return user;
	}

	@Override
	public List<User> list(Integer limit, Integer offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saveOrUpdate(User t) {
		User user = (User) sessionFactory.getCurrentSession().save(t);
		return user;
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub

	}
	
	

}
