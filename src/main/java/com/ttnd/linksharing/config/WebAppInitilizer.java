package com.ttnd.linksharing.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitilizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(WebMvcConfig.class);
		applicationContext.setServletContext(servletContext);
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher",
				new DispatcherServlet(applicationContext));
		registration.setLoadOnStartup(1);
		registration.addMapping("/");

	}

}
