package com.ttnd.linksharing.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ttnd.linksharing.dao.UserDao;
import com.ttnd.linksharing.dto.UserDTO;
import com.ttnd.linksharing.entity.User;

@Transactional
@Repository
public class UserDaoImp implements UserDao {
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
	public void saveOrUpdate(User t) {
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByUserNameOrEmail(UserDTO userDTO) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		Criterion username = Restrictions.eq("username", userDTO.getUsername());
		Criterion email = Restrictions.eq("email", userDTO.getEmail());
		LogicalExpression orExp = Restrictions.or(username, email);
		criteria.add(orExp);
		List<User> users = criteria.list();

		if (users != null && !users.isEmpty()) {
			return (User) users.get(0);
		}
		return null;
	}

	@Override
	public Long count() {
		return (Long) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setProjection(Projections.rowCount()).uniqueResult();
	}
}
