package com.ttnd.linksharing.filter;

import java.io.IOException;
import java.util.Arrays;
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

		if ((req.getSession().getAttribute("user") != null) || isAllowed(req)) {
			chain.doFilter(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		permitAllUrls = new HashSet<>(
				Arrays.asList("/login", "/register", "/resources/css", "/resources/js", "/resources/images"));
	}

	public boolean isAllowed(HttpServletRequest request) {
		boolean isAllowed = false;
		for (String url : permitAllUrls) {
			if ((request.getRequestURI()).contains(request.getContextPath() + url)) {
				isAllowed = true;
				break;
			}
		}
		return isAllowed;
	}

}
