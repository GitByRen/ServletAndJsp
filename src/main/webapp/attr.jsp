<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 属性的作用范围仅限于当前JSP页面 --> 
	pageContextAttr: <%= pageContext.getAttribute("pageContextAttr") %>
	<br><br>
	<!-- 属性的作用范围仅限于同一个请求,在有转发的情况下可以跨页面获取属性值 -->
	requestAttr: <%= request.getAttribute("requestAttr") %>
	<br><br>
	<!-- 属性的作用范围仅限于一次会话：浏览器打开直到关闭称之为一次会话（在此期间会话不失效） -->
	sessionAttr: <%= session.getAttribute("sessionAttr") %>	
	<br><br>
	<!-- 属性的作用范围仅限于当前WEB应用，停止或重启就会销毁 -->
	applicationAttr: <%= application.getAttribute("applicationAttr") %>
	
</body>
</html>