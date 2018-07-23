package com.important.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ServletContextListener：服务器reload会先销毁再创建
 * 
 * Listener有什么用?(创建数据库连接池，创建SpringIOC容器...)
 */
public class HelloListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {

	/**
	 * 当前web应用被加载时调用
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServeltContext对象被销毁");
	}

	/**
	 * 当前web应用被销毁时调用
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServeltContext对象被创建");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request被销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request被创建");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session被销毁");
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session被创建");
	}
}
