package com.important.filter.login;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.important.filter.HttpFilter;

public class LoginFilter extends HttpFilter {

	// 1.从web.xml中获取sessionKey,redirectUrl,uncheckedUrls
	private String sessionKey;
	private String redirectUrl;
	private String uncheckedUrls;

	@Override
	protected void init() {
		ServletContext servletContext = getFilterConfig().getServletContext();
		sessionKey = servletContext.getInitParameter("userSessionKey");
		redirectUrl = servletContext.getInitParameter("redirectPage");
		uncheckedUrls = servletContext.getInitParameter("uncheckedUrls");
	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 2.获取请求的servletPath
		String servletPath = request.getServletPath();

		// 3.检查servletPath是否为不需要检查的URL中的一个
		List<String> asList = Arrays.asList(uncheckedUrls.split(","));
		if (asList.contains(servletPath)) {
			chain.doFilter(request, response);
			return;
		}

		// 4.获取session值,若不存在则重定向
		Object user = request.getSession().getAttribute(sessionKey);
		if (user == null) {
			response.sendRedirect(request.getContextPath() + redirectUrl);
			return;
		}

		// 5.否则放行
		chain.doFilter(request, response);
	}

}
