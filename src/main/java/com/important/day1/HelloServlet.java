package com.important.day1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet容器:运行JSP,Filter,Listener等的软件环境
 * 1). 创建servlet,并调用Servlet的相关声明周期方法
 * 2). JSP,Filter,Listener,Tag...
 */
public class HelloServlet implements Servlet {

	/**
	 * Servlet的生命周期的方法
	 * 1.构造器：只被调用一次，第一次请求servlet时，创建servlet实例，调用构造器，这说明它是单例的
	 * 2.init方法：只被调用一次，在创建实例后立即被调用，用于初始化当前servlet
	 * 3.service：被多次调用，每次请求都会调用service方法，实际用于响应请求的
	 * 4.destroy：只被调用一次，在当前servlet所在的WEB应用被卸载前调用，用于释放当前servlet所占用的资源
	 */
	
	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("servletConfig");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("servletInfo");
		return null;
	}

	/**
	 * ServletConfig：封装了Servlet的配置信息，并且可以获取ServletContext对象
	 * getInitParameter(String name)：获取指定参数名的初始化参数
	 * getInitParameterNames()：获取参数名组成的Enumeration对象
	 */
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init");
		String user = servletConfig.getInitParameter("user");
		System.out.println("user:" + user);
		Enumeration<String> names = servletConfig.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = servletConfig.getInitParameter(name);
			System.out.println("name:" + name + ",value:" + value);
		}

		System.out.println("*******************");

		ServletContext servletContext = servletConfig.getServletContext();
		String driver = servletContext.getInitParameter("driver");
		System.out.println("driver:" + driver);
		Enumeration<String> names2 = servletContext.getInitParameterNames();
		while (names2.hasMoreElements()) {
			String name = names2.nextElement();
			String value = servletContext.getInitParameter(name);
			System.out.println("name:" + name + ",value:" + value);
		}
		
		// 获取当前WEB应用的某一个文件在服务器上的绝对路径，而不是部署前的路径
		String realPath = servletContext.getRealPath("/jdbc.properties");
		System.out.println(realPath);
		
		// 获取当前WEB应用的名称
		String contextPath = servletContext.getContextPath();
		System.out.println(contextPath);
		
		// 获取当前WEB应用的某一个文件对应的输入流
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream is1 = classLoader.getResourceAsStream("jdbc.properties");
		System.out.println("1." + is1);

		// /为当前WEB应用的根目录
		InputStream is2 = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
		System.out.println(is2);
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service");
	}
	
	public HelloServlet() {
		System.out.println("HelloServelt's constructor!");
	}

}
