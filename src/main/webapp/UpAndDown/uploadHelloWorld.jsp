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
		1.请求方式为post
		2.enctype="multipart/form-data"设置请求编码方式(以二进制传输数据)
	 -->
	<form action="<%=request.getContextPath() %>/uploadServlet" method="post" enctype="multipart/form-data">
		File:<input type="file" name="file"/>
		<input type="submit" value="Submit"/>
	</form>

</body>
</html>