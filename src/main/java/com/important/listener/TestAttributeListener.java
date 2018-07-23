package com.important.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class TestAttributeListener
		implements ServletContextAttributeListener, ServletRequestAttributeListener, HttpSessionAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("向request中添加了一个属性...");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("从request中移除了一个属性");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("request中属性替换了...");
	}
}
