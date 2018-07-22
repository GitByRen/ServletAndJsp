package com.important.filter.authority;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.important.filter.HttpFilter;

public class AuthorityFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String servletPath = request.getServletPath();
		List<String> uncheckList = Arrays.asList("/403.jsp", "/login.jsp", "/logout.jsp");

		if (uncheckList.contains(servletPath)) {
			chain.doFilter(request, response);
			return;
		}

		// 从session中获取user
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}

		// 获取该用户权限
		List<Authority> authorities = user.getAuthorities();

		// 检验是否有权限
		Authority authority = new Authority(null, servletPath);
		if (authorities.contains(authority)) {
			chain.doFilter(request, response);
			return;
		}
		
		response.sendRedirect(request.getContextPath() + "/403.jsp");
	}

}
