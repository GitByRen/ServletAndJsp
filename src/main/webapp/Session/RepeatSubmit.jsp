<%@page import="com.important.token.TokenProcessor"%>
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
		表单的重复提交：
			1).重复提交的情况: 
				①在表单提交到一个Servlet，而Servlet又通过请求转发的方式响应了一个JSP(HTML)页面，此时地址栏还保留着Servlet的那个路径，在
				响应页面点击刷新.
				②在响应页面没有到达时重复点击"提交"按钮
				③点击返回，再点击提交
			2).不是重复提交的情况:
				①点击返回，刷新原表单页面，在提交
				②response.redirect()也不是重复提交
			3).如何避免重复提交:
				①仅提供一个隐藏域：行不通，没有方法清除固定的请求参数
				②把标记放在request中：行不通，因为表单刷新后，request已经被销毁，在提交表单是新的request
				③session+隐藏域：可以
	 -->

	<%--
		String tokenValue = new Date().getTime() + "";
		session.setAttribute("token", tokenValue);
	--%>

	<%-- <form action="<%=request.getContextPath() %>/TokenServlet" method="post">
		<input type="hidden" name="token" value="<%=tokenValue %>"/>
		username:<input type="text" name="tokens" /> 
		<input type="submit" />
	</form>  --%>

	<form action="<%=request.getContextPath() %>/TokenServlet" method="post">
		<input type="hidden" name="TOKEN_KEY" value="<%=TokenProcessor.getInstance().saveToken(request) %>"/>
		username:<input type="text" name="tokens" /> 
		<input type="submit" />
	</form>

</body>
</html>