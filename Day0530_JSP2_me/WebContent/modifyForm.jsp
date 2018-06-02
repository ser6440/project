<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% Member member = (Member)request.getAttribute("member"); %>
    <%--Attribute는 오브젝트이니까 형변환시켜줘야한다. --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<p><label>아이디: <input type="text" name="userid" readonly="readonly" value="<%=member.getId() %>"></label></p>
		<p><label>비&nbsp;&nbsp;&nbsp;번: <input type="password" name="userpw"></label></p>
		<p><label>이&nbsp;&nbsp;&nbsp;름: <input type="text" name="name" value="<%=member.getName() %>"></label></p>
		<p><label>이메일: <input type="text" name="email" value="<%=member.getEmail()%>"></label></p>
		<p><label>가입일: <input type="text" name = "regDate" readonly="readonly" value="<%=member.getRegDate()%>"></label></p>
		<input type="submit" value="수정하기">
		<input type="reset" value="다시 작성">
	</form>
</body>
</html>