package com.ttnd.linksharing.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ttnd.linksharing.dao.UserDao;
import com.ttnd.linksharing.entity.User;
import com.ttnd.linksharing.utils.FileUtils;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserDao userDao;

	@Autowired
	ServletContext servletContext;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub

		if (userDao.count() == 0) {
			User user = new User();
			user.setFirstName("admin");
			user.setLastName("test");
			user.setUsername("admin@gmail.com");
			user.setEmail("admin@gmail.com");
			user.setPassword("igdefault");

			try {
				user.setPhoto(
						FileUtils.getBytes(servletContext.getRealPath("/resources/images") + "/default_avatar.jpg"));
				userDao.saveOrUpdate(user);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
