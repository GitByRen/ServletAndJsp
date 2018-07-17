<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- el自动类型转换 -->
	score:${param.score + 11 }
	
	<br/>
	names:${paramValues.name[0] }
	
	<br/>
	time:${applicationScope.time.time }
	
	<!-- 以下了解即可 -->
	<br/>
	JSessionID:${cookie.JSESSIONID.name } -- ${cookie.JSESSIONID.value }
	<!-- 其他隐含对象 -->
	<br/>
	Accept-Lanuage:${header["Accept-Language"] }
	<!-- pageContext的初始化参数 -->
	<br/>
	initParam:${initParam.loginServlet }
	
	<br/>
	
	<!-- 重要 -->
	contextPath:${pageContext.request.contextPath }
	<br/>
	sessionId:${pageContext.session.id }
	<!-- EL的关系运算符 -->
	<br/>
	${param.score > 60 ? "及格" : "不及格" }
	
	<!-- Empty：可以作用于集合，若该集合不存在或者没有元素，结果都为true -->
	<br/>
	empty:${empty requestScope.names }
</body>
</html>