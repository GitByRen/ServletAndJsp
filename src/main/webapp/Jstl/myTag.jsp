<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.important.tag.Customer"%>
<%@ taglib uri="http://www.important.com/mytag/core" prefix="i"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		1.自定义标签
			①创建一个标签处理器类，实现SimpleTag接口.
			②建立.tld文件
			③在tld文件中描述自定义标签
	 -->
	<!-- 不写value值会报错，count不能用\${}\动态值 -->
	<i:hello value="${param.values }" count="10"/>
	
	<!-- 练习：读取文件输出到页面 -->
	<i:readerFile src="/WEB-INF/error.jsp"/>
	
	<!-- 带标签体的自定义标签 -->
	<i:testJspFragment>HelloWorld!</i:testJspFragment>

	<br/><br/><br/><br/>
	<!-- 自定义标签实现c:foreach -->
	<%
		List<Customer> list = new ArrayList<Customer>();
		list.add(new Customer(1, "A"));
		list.add(new Customer(2, "B"));
		list.add(new Customer(3, "C"));
		list.add(new Customer(4, "D"));
		list.add(new Customer(5, "E"));
		request.setAttribute("customers", list);
	%>

	<i:foreach items="${requestScope.customers }" var="cus">
		${cus.id } --- ${cus.name }<br/>
	</i:foreach>

</body>
</html>