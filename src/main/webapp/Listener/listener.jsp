<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.important.listener.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 从文件中读取的时间一样，但是却是新的session，因为缓存 -->
	<%
		TestBindingListener customer = (TestBindingListener) session.getAttribute("customer");
		if (customer == null) {
			customer = new TestBindingListener();
			customer.setTime(new Date());
			session.setAttribute("customer", customer);
			System.out.println("创建一个新的Customer对象" + customer);
		} else {
			System.out.println("从session中读取Customer对象" + customer);
		}
	%>

</body>
</html>