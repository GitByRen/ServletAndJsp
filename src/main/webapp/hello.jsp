<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %> <!-- errorPage="/WEB-INF/error.jsp" -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- JSP指令 -->
	<!-- 1.session="true|false" errorPage="relative_url" isErrorPage="true|false"-->
	<!-- 2.contentType：指定当前JSP页面的响应类型,实际调用的是response.setContentType("text/html; charset=UTF-8") -->
	<!-- 3.pageEncoding：指定当前JSP页面的字符编码 -->
	<%
		/* 在响应error.jsp时,jsp引擎使用的是转发的方式 */
		int i = 10/0;
	%>
	
	<!-- 
		JSP九大内置对象:即未声明就可以使用的对象
		request,response,pageContext,session,application,config,out,page,exception
		>>> 这样记忆：pageContext,request,session,application(对属性的作用域的范围从小到大)
					out,response,config,page,exception
	 -->
	
	<%
		// 1.HttpServletRequest的一个对象
		String name = request.getParameter("name");
		System.out.println(name);
		
		// 2.HttpServletResponse的一个对象
		System.out.println(response instanceof HttpServletResponse);
		
		// 3.pageContext是页面的上下文,是PageContext的一个对象，可以从该对象中获取到其他8个隐含对象，也可以从中获取到当前页面的其他信息
		ServletRequest req = pageContext.getRequest();
		System.out.println(request == req);
		
		// 4.session:是HttpSession的一个对象
		
		// 5.application:代表当前web应用，是ServletContext的对象
		System.out.println(application.getInitParameter("driver"));
		
		// 6.config:当前JSP对应的Servlet的ServletConfig的对象
		System.out.println(config.getInitParameter("test"));
		
		// 7.out:JspWritter的对象
		out.println("哈哈...");
		out.println("嘿嘿...");
		out.println("<br/>");
		
		// 8.page:指向当前JSP对应的Servlet对象的引用，但为Object类型，只能调用Object类的方法
		out.println(this);
		out.println("<br/>");
		out.println(page);
		
		// 9.exception:只有主动声明了isErrorPage="true"才可用
	%>

</body>
</html>