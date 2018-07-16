<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		1.EL变量范围：默认从pageContext范围找，假如找不到，再依次到request,session,application范围。
		2.EL可以进行自动的类型转换
		3.EL隐含对象：
			pageScope, requestScope, sessionScope, applicationScope (范围相关)
			param, paramValues (输入相关)
			cookie (其他)
	 -->

	<form action="el.jsp" method="post">
		username: <input type="text" name="username"
			value="<%=request.getParameter("username") == null ? "" : request.getParameter("username")%>" />
		<!--  
			EL 表达式的优点: 简洁!
		-->
		username: <input type="text" name="username"
			value="${param.username }" /> <input type="submit" value="Submit" />
	</form>
	
	<%
		session.setAttribute("com.atguigu.customer", "aaa");
	%>
	<!-- 某些时候需要用[]获取属性 -->
	name:${sessionScope["com.atguigu.customer"] }
	
	<br/><br/>
	
	<a href="el2.jsp?score=98&name=A&name=B">el2</a>
	<%application.setAttribute("time",new Date());%>
</body>
</html>