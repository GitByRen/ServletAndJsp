<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.important.mvc.domain.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="query.do" method="post">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Query"/></td>
				<td><a href="">Add New Customer</a></td>
			</tr>
		</table>
	</form>
	
	<table border="1" cellpadding="10" cellspacing="0">
	<%
		List<Customer> customers = (List<Customer>) request.getAttribute("customers");
		if (customers != null && customers.size() > 0){
			for(Customer customer : customers){
	%>
			<tr>
				<td><%=customer.getId() %></td>
				<td><%=customer.getName() %></td>
				<td><%=customer.getAddress() %></td>
				<td><%=customer.getPhone() %></td>
				<td>
					<a href="">UPDATE</a>
					<a href="">DELETE</a>
				</td>
			</tr>
	<%	
			}
		}
	%>
	</table>
</body>
</html>