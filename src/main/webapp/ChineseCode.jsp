<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>BBB</h4>

	<!-- 对于POST请求，这样才能显示中文 -->
	<%
		request.setCharacterEncoding("UTF-8");
	%>

	<!-- 这样直接接收中文会乱码 -->
	username:<%=request.getParameter("username") %>
	
	<br>
	
	<!-- 对于GET请求，也可以修改tomcat的server.xml文件,connector添加useBodyEncodingForURI="true" -->
	<%
		String val = request.getParameter("username");
		String username = new String(val.getBytes("ISO-8859-1"),"UTF-8");
		out.println(username);
	%>
	
</body>
</html>