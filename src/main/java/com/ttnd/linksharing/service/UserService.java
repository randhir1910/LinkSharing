package com.ttnd.linksharing.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ttnd.linksharing.dto.UserDTO;
import com.ttnd.linksharing.exception.NotFoundException;

public interface UserService {

	public UserDTO get(Integer id);

	public List<UserDTO> list(Integer limit, Integer offset);

	public void saveOrUpdate(UserDTO t);

	public void delete(UserDTO t);

	public void login(HttpServletRequest request, UserDTO userDTO) throws NotFoundException;

	public boolean isLoggedIn(HttpServletRequest request);
}
