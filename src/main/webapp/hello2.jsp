<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Date date = new Date();
		out.println(date);
	%>
	
	<!-- JSP表达式 -->
	<%= date %>
	
	<!-- JSP声明，它里面的代码将被插入进Servlet的_jspService方法的外面，了解即可 -->
	<%!
		void test(){}
	%>
	
	<%-- JSP注释:可以阻断java代码的执行 --%><!-- HTML注释:不能阻断java代码的执行 -->
	<!--
		<%
			System.out.println("aaa..");
		%>
	-->
	
	<br/><br/><br/><br/>
	
	<%
		/* 域的属性操作  */
		pageContext.setAttribute("pageContextAttr","pageContextValue");
		request.setAttribute("requestAttr","requestValue");
		session.setAttribute("sessionAttr","sessionValue");
		application.setAttribute("applicationAttr","applicationValue");
	%>

	<br><br>
	pageContextAttr: <%= pageContext.getAttribute("pageContextAttr") %>
	<br><br>
	requestAttr: <%= request.getAttribute("requestAttr") %>
	<br><br>
	sessionAttr: <%= session.getAttribute("sessionAttr") %>	
	<br><br>
	applicationAttr: <%= application.getAttribute("applicationAttr") %>
	
	<br><br>
	<a href="attr.jsp">To Attr2 Page</a>
	
	<%
// 		request.getRequestDispatcher("/attr.jsp").forward(request, response);
	%>
	<br><br>
	
	<!-- 转发和重定向 -->
	<a href="forwardServlet">Forward</a>
	<a href="redirectServlet">Redirect</a>
</body>
</html>