package com.important.listener;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * HttpSessionBindingListener:监听现了该接口的Java类绑定session的listener,这个不需要在web.xml文件中进行配置
 * HttpSessionActivationListener:监听实现了该接口和Serializable接口的Java类的对象随session钝化和活化的事件,这个不需要在web.xml文件中进行配置
 * > 活化：读取session对象 > 钝化：写入session对象
 */
public class TestBindingListener implements HttpSessionBindingListener, HttpSessionActivationListener, Serializable {

	private static final long serialVersionUID = 1L;

	private Date time;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "TestBindingListener [time=" + time + "]";
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("绑定到session上");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("从session解除绑定");
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("从内存中写到磁盘上..");
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("从磁盘中读取出来");
	}
}
