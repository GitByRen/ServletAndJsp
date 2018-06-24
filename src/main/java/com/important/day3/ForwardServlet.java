package com.important.day3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 本质区别：请求的转发只发出了一次请求，重定向发出了两次请求.
 * 1. 转发的地址栏是初次发出请求的地址，重定向的地址栏为最后响应的地址.
 * 2. 转发：在最终的Servlet中，request对象和中转的那个request是同一个对象.
 * 	     重定向：在最终的Servlet中，request对象和中转的那个request不是同一个对象.
 * 3. 转发：浏览器-服务器-转发-返回浏览器，只能转发给当前WEB应用的资源.
 * 	     重定向：浏览器-服务器-浏览器-服务器-返回浏览器，可以重定向到任何资源.
 * 4. 转发：/代表的是当前WEB应用的根目录.  http://localhost:8080/ServletAndJsp
 * 	     重定向：/代表的是当前WEB站点的根目录. http://localhost:8080/...
 */
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Forward...");
		// 请求的转发
		// 1.调用HttpServletRequest的getRequestDispatcher方法获取RequestDispatcher对象
		String path = "testServlet";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/" + path);
		// 2.调用HttpServletRequest的forward(request,response)进行转发
		requestDispatcher.forward(request, response);
	}

}
