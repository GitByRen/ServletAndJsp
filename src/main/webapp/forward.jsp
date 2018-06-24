<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	forward.....
	
	<br>
	<!-- 测试中文乱码 -->
	<%-- 
 	<jsp:forward page="/WEB-INF/ChineseCode/a.jsp"></jsp:forward>
 	--%>
	
	<!-- 动态跳转 -->
	<%--
	<jsp:forward page="/WEB-INF/JspTag/forwardOrInclude.jsp">
		<jsp:param value="uuu" name="uname"/>
	</jsp:forward>
	--%>
	
	<!-- 静态跳转 -->
	<%--
	<jsp:include page="/WEB-INF/JspTag/forwardOrInclude.jsp">
		<jsp:param value="uuu" name="uname"/>
	</jsp:include>
	--%>
</body>
</html>