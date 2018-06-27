package com.important.mvc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
		// 需要维护两处代码 switch和add...方法，麻烦
//		String method = request.getParameter("method");
//		switch (method) {
//		case "add":
//			add(request, response);
//			break;
//		case "query":
//			query(request, response);
//			break;
//		case "delete":
//			delete(request, response);
//			break;
//		case "update":
//			update(request, response);
//			break;
//		default:
//			break;
//		}
//	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 3);
		System.out.println(methodName);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) {

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("delete");
	}

	private void query(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("query");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("add");
	}

}
