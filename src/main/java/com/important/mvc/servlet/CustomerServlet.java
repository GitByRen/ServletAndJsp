package com.important.mvc.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.important.mvc.dao.CustomerDAO;
import com.important.mvc.domain.Customer;
import com.important.mvc.impl.CustomerDAOJdbcImpl;

public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerDAO cusDao = new CustomerDAOJdbcImpl();
	
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
		// /addCustomer.do
		String methodName = servletPath.substring(6);
		methodName = methodName.substring(0, methodName.length() - 3);
		System.out.println(methodName);
		try {
			Method declaredMethod = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			declaredMethod.invoke(this, request, response);
		} catch (Exception e) {
			response.sendRedirect("error.jsp");
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) {

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("delete");
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> all = cusDao.getAll();
		request.setAttribute("customers", all);
		request.getRequestDispatcher("/app1/index.jsp").forward(request, response);
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("add");
	}

}
