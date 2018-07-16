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
	
	<br/>
	JSessionID:${cookie.JSESSIONID.name } -- ${cookie.JSESSIONID.value }
</body>
</html>