package com.ttnd.linksharing.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttnd.linksharing.dao.CommonDao;
import com.ttnd.linksharing.dto.UserDTO;
import com.ttnd.linksharing.entity.User;
import com.ttnd.linksharing.service.CommonService;

@Service
public class UserService implements CommonService<UserDTO> {

	@Autowired
	private CommonDao<User> commonDao;

	@Override
	public UserDTO get(Integer id) {
		UserDTO userDTO = null;
		User user = commonDao.get(id);
		if (user != null) {
			userDTO = new UserDTO();
			BeanUtils.copyProperties(user, userDTO);
		}
		return userDTO;
	}

	@Override
	public List<UserDTO> list(Integer limit, Integer offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO saveOrUpdate(UserDTO userDTO) {
		User user = null;
		BeanUtils.copyProperties(userDTO, user);
		user = commonDao.saveOrUpdate(user);
		BeanUtils.copyProperties(user, userDTO);
		return userDTO;
	}

	@Override
	public void delete(UserDTO t) {
		// TODO Auto-generated method stub

	}
}
