<%@page import="model.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	
	<% List<Member> memberList 
	=  (List<Member>)request.getAttribute("memberList");%> 
	
	
	${requestScope.memberList}<br>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일</th>
		</tr>
		<%  for (int i=0;i<memberList.size();i++){
		%>   <tr>
				<td><%=memberList.get(i).getId()%></td>
				<td><%=memberList.get(i).getName()%></td>
				<td><%=memberList.get(i).getEmail()%></td>
				<td><%=memberList.get(i).getRegDate()%></td>
			</tr>
		<%	
		}%>
		
		<c:forEach items="${memberList}" var="member">
		
		</c:forEach>
	</table>
	<a href="main">메인화면으로 </a>


</body>
</html>





