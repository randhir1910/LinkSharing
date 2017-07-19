package com.ttnd.linksharing.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttnd.linksharing.dao.UserDao;
import com.ttnd.linksharing.dao.impl.UserDaoImp;
import com.ttnd.linksharing.dto.UserDTO;
import com.ttnd.linksharing.entity.User;
import com.ttnd.linksharing.exception.NotFoundException;
import com.ttnd.linksharing.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDTO get(Integer id) {
		UserDTO userDTO = null;
		User user = userDao.get(id);
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
	public void saveOrUpdate(UserDTO userDTO) {
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		userDao.saveOrUpdate(user);
	}

	@Override
	public void delete(UserDTO t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void login(HttpServletRequest request, UserDTO userDTO) throws NotFoundException {
		User user = userDao.findByUserNameOrEmail(userDTO);
		if (user != null) {
			if (userDTO.getPassword().equals(user.getPassword())) {
				System.out.println("userDTO-->>" + userDTO.getPassword());
				System.out.println("user----->>" + user.getPassword());
				user.setPassword("");
				request.getSession().setAttribute("user", user);
				return;
			}
		}
		throw new NotFoundException("User not found");
	}

	@Override
	public boolean isLoggedIn(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") != null) {
			return true;
		}
		return false;
	}
}
