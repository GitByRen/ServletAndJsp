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
import com.important.mvc.factory.CustomerDAOFactory;

public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 这样不好
//	private CustomerDAO cusDao = new CustomerDAOJdbcImpl();
	private CustomerDAO cusDao = CustomerDAOFactory.getInstance().getCustomerDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	// protected void doPost(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// 需要维护两处代码 switch和add...方法，麻烦
	// String method = request.getParameter("method");
	// switch (method) {
	// case "add":
	// add(request, response);
	// break;
	// case "query":
	// query(request, response);
	// break;
	// case "delete":
	// delete(request, response);
	// break;
	// case "update":
	// update(request, response);
	// break;
	// default:
	// break;
	// }
	// }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String servletPath = request.getServletPath();
		// /app1/addCustomer.do
		String methodName = servletPath.substring(6);
		methodName = methodName.substring(0, methodName.length() - 3);
		try {
			Method declaredMethod = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			declaredMethod.invoke(this, request, response);
		} catch (Exception e) {
			response.sendRedirect("error.jsp");
		}
	}

	// 修改时用户名不能重复
	private void update(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String oldName = request.getParameter("oldName");
		// mysql不区分大小写
		if (!oldName.equalsIgnoreCase(name)) {
			// 去数据库校验名字是否重复...
		}
		// ...
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String parameter = request.getParameter("id");
		int id = 0;

		// try ... catch的作用：防止parameter不能转为int类型
		// 若不能转则id=0，不进行删除操作，直接redirect
		try {
			id = Integer.parseInt(parameter);
			cusDao.delete(id);
		} catch (Exception e) {
		}

		response.sendRedirect("query.do");
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> all = cusDao.getAll();
		request.setAttribute("customers", all);
		request.getRequestDispatcher("/app1/index.jsp").forward(request, response);
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 1.获取参数
		String name = request.getParameter("username");

		// 2.验证用户名是否重复
		long count = cusDao.getCountWithName(name);
		if (count > 0) {
			request.setAttribute("message", "用户名为" + name + "的以重复！");
			// 如果重复，还可以回显，因为是转发，都是一个request
			request.getRequestDispatcher("/addCustomer.do").forward(request, response);
			return;
		}

		// 3.验证通过则添加

		// 4.重定向到success.jsp页面，如果用转发，则再次刷新页面时，会重新提交表单
		response.sendRedirect("success.jsp");

	}

}
