<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		> response.encodeURL("show.jsp"):URL重写，解决禁用Cookie的问题
		
		> 绝对路径的问题：在由Servelt转发到JSP页面时，此时浏览器地址栏上显示的是Servelt的路径，而
		JSP页面的超链接还是相对于该JSP页面的地址，则可能会出现路径混乱的问题
		a.jsp -> /Servlet转发 -> b.jsp(有一个超链接：和b.jsp在同一路径下的c.jsp) -> 无法得到页面.
		
		> 什么叫绝对路径? 相对于contextPath的路径
		
		> JavaWeb中的 / 到底代表什么?
			① 当前WEB应用的根路径：http://localhost:8989/contextPath
				1). 请求转发时：request.getRequestDispatcher("").forward(..);
				2). web.xml文件中映射Servlet访问路径
			② 当前WEB站点的根路径：http://localhost:8989/
				1). 超链接 ：<a href="/TestServlet"></a>
				2). 表单中的action：<form action="/login">
				3). 请求重定向时：response.sendRedirect("/a.jsp")
	 -->

	SessionId:<%=session.getId() %><br/>
	<%
		Object username = session.getAttribute("username");
	%>
	
	<form action="<%=response.encodeURL("show.jsp") %>" method="post">
		<input type="text" name="username" value="<%=username %>"/>
		<input type="submit"/>
	</form>

</body>
</html>