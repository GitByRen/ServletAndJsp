package com.important.filter.authority;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorityServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UserDao userDao = new UserDao();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void getAuthorities(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		User user = userDao.get(username);
		request.setAttribute("user", user);
		request.setAttribute("authorities", userDao.getAuthorities());
		request.getRequestDispatcher("/Filter/authority/authority-manager.jsp").forward(request, response);
	}

	protected void updateAuthoritys(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		// 页面上的勾选的权限
		String[] authorities = request.getParameterValues("authority");
		// 封装参数
		List<Authority> authorityList = userDao.getAuthorities(authorities);
		// 更新
		userDao.update(username, authorityList);
		response.sendRedirect(request.getContextPath() + "/Filter/authority/authority-manager.jsp");
	}
}
