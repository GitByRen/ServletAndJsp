<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" import="javax.servlet.http.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		Cookie机制采用的是在客户端保持HTTP状态信息的方案。
		Cookie机制：①第一次访问不存在Servlet的Cookie，第一次请求到WEB服务器后，服务器会
		响应一个Cookie给浏览器，后续访问浏览器会携带Cookie到服务器，看是否为一次会话。
	 -->
	<%
		// 1.创建一个Cookie对象
		//Cookie cookie = new Cookie("name","atguigu");
		// 2.将cookie传给客户端
		//response.addCookie(cookie);
		
			
		// 1.获取Cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie ckie : cookies) {
				// 获取名字和值
				out.println(ckie.getName() + ": " + ckie.getValue());
			}
		} else {
			out.println("cookie制造中....");
			// 2.创建Cookie
			Cookie cookie = new Cookie("name", "atguigu");
			// 设置Cookie的最大时效，以秒为单位，若为0，表示立即删除cookie;若为负数，表示不存储Cookie
// 			cookie.setMaxAge(30);
			
			// Cookie的作用范围：可以作用当前目录和当前目录的子目录，但不能作用于当前目录的上一级目录
			// 可以通过setPath方法设置Cookie的作用范围,/代表站点根目录
			cookie.setPath(request.getContextPath());
			
			response.addCookie(cookie);
		}
	%>

</body>
</html>