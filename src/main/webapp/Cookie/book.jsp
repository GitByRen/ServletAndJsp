<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.servlet.http.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h4>Book Detail Page</h4>
	
	Book: <%= request.getParameter("book") %>
	
	<br><br>
	
	<a href="<%=application.getContextPath() %>/Cookie/books.jsp">Return</a>
	
	<% 
		String book = request.getParameter("book");
	
		Cookie[] cookies = request.getCookies();
		List<Cookie> list = new ArrayList<>();
		Cookie temp = null;
		if(cookies != null && cookies.length>0){
			for(Cookie coo : cookies){
				String name = coo.getName();
				if(name.startsWith("ATGUIGU_BOOK_")){
					list.add(coo);
					// 已经存在cookie中的信息和点击的相等
					if(coo.getValue().equals(book)){
						temp = coo;
					}
				}
			}
		}
		
		if(list.size() >= 5 && temp == null){
			temp = list.get(0);
		}
		
		if(temp != null){
			temp.setMaxAge(0);
			response.addCookie(temp);
		}
		
		Cookie cookie = new Cookie("ATGUIGU_BOOK_" + book, book);
		response.addCookie(cookie);
		
	%>
	
</body>
</html>