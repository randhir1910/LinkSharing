package com.ttnd.linksharing.dao;

import java.util.List;

import com.ttnd.linksharing.dto.UserDTO;
import com.ttnd.linksharing.entity.User;

public interface UserDao {

	public User get(Integer id);

	public List<User> list(Integer limit, Integer offset);

	public void saveOrUpdate(User t);

	public void delete(User t);

	public User findByUserNameOrEmail(UserDTO userDTO);

	public Long count();
}
