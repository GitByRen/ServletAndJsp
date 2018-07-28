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
	   Servlet写法：
		response.setContentType("application/x-msdownload"); 
		String fileName = "文件下载.pptx";
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
	 -->

	<%
		// 1.通知客户端浏览器：这是一个需要下载的文件，不能再按普通的html的方式打开
		response.setContentType("application/x-msdownload");
		// 2.通知客户端浏览器：不再由浏览器处理文件，而是交由用户自行处理
		response.setHeader("Content-Disposition", "attachment;filename=abc.txt");
	%>

	<!-- 静态下载，右键另存为即可 -->
<!-- 	<a href="upload.jsp">xyz</a> -->
	

</body>
</html>