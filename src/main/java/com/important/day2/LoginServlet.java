package com.important.day2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginServlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	/**
	 * ServletRequest:封装了请求信息，可以从中获取到任何的请求信息 
	 * ServletResponse:封装了响应信息
	 * 这两个接口的实现类都是服务器给予实现的,并在服务器调用service方法时传入
	 */
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// 根据请求参数名，返回参数值
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		System.out.println(user + " " + password);
		// 根据请求参数名，返回字符串数组
		String[] parameterValues = request.getParameterValues("interesting");
		for (String interesting : parameterValues) {
			System.out.println(interesting);
		}
		// 返回参数名对应的Enumeration对象
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = request.getParameter(name);
			System.out.println(name + " " + value);
		}

		// 返回请求参数的键值对
		Map<String, String[]> map = request.getParameterMap();
		for (Map.Entry<String, String[]> maps : map.entrySet()) {
			System.out.println(maps.getKey() + " " + Arrays.asList(maps.getValue()));
		}

		// 其他方法
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String requestURI = httpServletRequest.getRequestURI();
		System.out.println(requestURI);

		String method = httpServletRequest.getMethod();
		System.out.println(method);
		
		// 获取GET方法传递的参数
		String queryString = httpServletRequest.getQueryString();
		System.out.println(queryString);
		
		// 获取servlet的映射路径  /loginServlet
		String servletPath = httpServletRequest.getServletPath();
		System.out.println(servletPath);
		
		System.out.println("************************");

		// 设置响应的内容类型
		response.setContentType("application/msword");
		// getWriter():返回PrintWriter对象，调用该对象的print()方法，把参数直接打印到客户的浏览器上
		PrintWriter writer = response.getWriter();
		writer.write("aaa...");
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}

}
