package com.important.day2;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * GenericServlet:为了简化开发而存在
 */
public class LoginServlet2 extends GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// 1.因为父类中有init(ServletConfig config)方法，所以不建议直接覆盖该方法，否则config为null
		// 2.如果直接覆盖了init(ServletConfig config)，可以调用super.init(config)避免空指针
		// 3.新建的init方法并非servlet的生命周期方法.而init(ServletConfig config)是生命周期相关的方法
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("...");
	}

}
