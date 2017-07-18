package com.ttnd.linksharing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ttnd.linksharing.dto.UserDTO;

@Controller
public class UserController {
	@RequestMapping(value = { "/", "/login", "/register" }, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("userDTO", new UserDTO());
		return "index";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String login(UserDTO userDTO) {
		System.out.println("===username=>>>" + userDTO.getUsername());
		System.out.println("=======>>" + userDTO.getEmail());
		System.out.println("===password=>>>" + userDTO.getPassword());

		return "dashboard";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String register(@ModelAttribute("userDTO") UserDTO userDTO) {
		/*System.out.println(userDTO.getFirstName());
		System.out.println(userDTO.getEmail());
		System.out.println(userDTO.getLastName());*/
		return "dashboard";
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String test(UserDTO userDTO, Model model) {
		return "dashboard";
	}
}
