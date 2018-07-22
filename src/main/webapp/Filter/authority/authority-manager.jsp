<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="<%=request.getContextPath() %>/AuthorityServlet?method=getAuthorities" method="post">
		username:<input type="text" name="username"/>
		<input type="submit" value="submit"/>
	</form>
	
	<c:if test="${requestScope.user != null }">
		${requestScope.user.username }的权限是：
		<br/><br/>
		<form action="<%=request.getContextPath() %>/AuthorityServlet?method=updateAuthoritys" method="post">
			<input type="hidden" name="username" value="${requestScope.user.username }"/>
			
			<c:forEach items="${authorities }" var="auth"> 
				<c:set var="flag" value="false"></c:set>
				<!-- 打钩 -->
				<c:forEach items="${user.authorities }" var="ua">
					<c:if test="${auth.url == ua.url }">
						<c:set var="flag" value="true"></c:set>
					</c:if>
				</c:forEach>
				
				<!-- 展示 -->
				<c:if test="${flag == true }">
					<input type="checkbox" checked="true" name="authority" value="${auth.url }"/>${auth.displayName }
				</c:if>
				<c:if test="${flag == false }">
					<input type="checkbox" name="authority" value="${auth.url }"/>${auth.displayName }
				</c:if>
				<br/><br/>
			</c:forEach>
			
			<input type="submit" value="update"/>
		</form>
	</c:if>
	
</body>
</html>