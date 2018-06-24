package com.important.day3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RedirectServlet...");
		
		// TestServlet中获取不到该值，因为发了两次请求，不是同一个request对象
		request.setAttribute("names", "xxx");
		System.out.println("RedirectServlet:" + request.getAttribute("names"));
		
		// 执行请求的重定向
		String path = "testServlet";
		response.sendRedirect(path);
	}

}
