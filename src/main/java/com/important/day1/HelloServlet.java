package com.important.day1;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
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
	 * Servlet的声明周期的方法
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

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service");
	}
	
	public HelloServlet() {
		System.out.println("HelloServelt's constructor!");
	}

}
