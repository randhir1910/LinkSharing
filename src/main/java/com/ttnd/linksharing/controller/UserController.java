package com.ttnd.linksharing.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ttnd.linksharing.dto.UserDTO;
import com.ttnd.linksharing.exception.NotFoundException;
import com.ttnd.linksharing.service.UserService;
import com.ttnd.linksharing.service.impl.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/login", "/register" }, method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		if (userService.isLoggedIn(request)) {
			return "redirect:/dashboard";
		}
		model.addAttribute("userDTO", new UserDTO());
		return "index";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String login(HttpServletRequest request, UserDTO userDTO, Model model) {

		String view = "redirect:/dashboard";

		try {
			userService.login(request, userDTO);
		} catch (NotFoundException e) {
			model.addAttribute("message", e.getMessage());
			view = "index";
		}

		return view;
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String register(HttpServletRequest request, @ModelAttribute("userDTO") UserDTO userDTO) {

		System.out.println("-------------->>>>" + userDTO.getFirstName());
		System.out.println(userDTO.getUserImage());
		System.out.println(userDTO.getPhoto());
		userService.saveOrUpdate(userDTO);
		try {
			userService.login(request, userDTO);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/dashboard";
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login";
	}
}
