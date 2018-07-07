<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false" import="javax.servlet.http.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
	  Session机制采用的是在服务器端保持HTTP状态信息的方案。
	  Session机制：第一次访问WEB服务器后，服务器会传一个JSESSIONID的Cookie给客户端，
	    后续访问浏览器会携带JSESSIONID的Cookie到服务器，看是否为一次会话。
	  
	  1. HttpSession 的生命周期:
	  	1). 什么时候创建HttpSession对象
	  		①.对于JSP:是否浏览器访问服务端的任何一个JSP,服务器都会立即创建一个 HttpSession对象呢?
	  			不一定。
	    	> 若当前的JSP是客户端访问的当前WEB应用的第一个资源,且JSP的page指定的session属性值为false,
	    	     则服务器就不会为JSP创建一个 HttpSession对象;
	    	> 若当前JSP不是客户端访问的当前WEB应用的第一个资源,且其他页面已经创建一个HttpSession 对象,
	 		     则服务器也不会为当前JSP页面创建一个HttpSession对象,而会把和当前会话关联的那个HttpSession对象返回给当前的JSP页面。
	  		②.对于Serlvet:若Serlvet是客户端访问的第一个WEB应用的资源,
	  		     则只有调用了request.getSession()或request.getSession(true)才会创建HttpSession对象
	  		
	  	2). page指令的session="false"到底表示什么意思?
	    	> 当前JSP页面禁用session隐含变量!但可以使用其他的显式的HttpSession对象
	  	
	  	3). 在Servlet中如何获取HttpSession对象?
	  		> request.getSession(boolean create):
	  		create为false,若没有和当前JSP页面关联的HttpSession对象，则返回null;若有,则返回true;  
	  		create为true,一定返回一个HttpSession对象;若没有和当前JSP页面关联的HttpSession对象则创建，否则返回;
	  	
	  		> request.getSession():等同于request.getSession(true);
	  	
	  	4). 什么时候销毁HttpSession对象?
	  		①. 直接调用HttpSession的invalidate()方法
	  		②. 服务器卸载了该WEB应用
	  		③. 超出HttpSession的过期时间
	  			> session.setMaxInactiveInterval(5)设置过期时间,单位是秒
	  			> web.xml中添加：单位是分钟
  				<session-config>
  					<session-timeout>30</session-timeout>
  				</session-config>
  			④. 并不是关闭了浏览器就销毁了HttpSession,因为可以通过持久化cookie的方式保持session
	 -->
	 
	 <%
		HttpSession session = request.getSession(true); 
		out.println(session.getId());
	 	out.println(session.getMaxInactiveInterval());
	 	
	 	// 是否新创建的session
	 	out.println(session.isNew());
	 	// 创建时间
	 	out.println(session.getCreationTime());
	 	// 上次访问时间 
	 	out.println(session.getLastAccessedTime());

	 	session.setAttribute("username", "aaa");
	 	
	 	// 使当前session失效
// 	 	session.invalidate();
	 %>
	 
	 <%=session.getAttribute("username") %>

</body>
</html>