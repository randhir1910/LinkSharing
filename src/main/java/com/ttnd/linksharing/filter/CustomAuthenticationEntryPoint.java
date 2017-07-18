package com.ttnd.linksharing.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@WebFilter(urlPatterns = "/*")
public class CustomAuthenticationEntryPoint implements Filter {

	Set<String> permitAllUrls;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		System.out.println("Request Uri -->>>" + req.getRequestURI());
		System.out.println("Is req allowed -->>>" + permitAllUrls.contains(req.getRequestURI()));
		if (permitAllUrls.contains(req.getRequestURI())) {
			chain.doFilter(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		permitAllUrls = new HashSet<>();
		permitAllUrls.add(config.getServletContext().getContextPath() + "/");
		permitAllUrls.add(config.getServletContext().getContextPath() + "/login");
		permitAllUrls.add(config.getServletContext().getContextPath() + "/register");
	}

}
