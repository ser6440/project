<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//생성할 때, 쿠키의 이름과 데이터를 생성자의 파라미터로 넣어줌
// 	Cookie cookie = new Cookie("name","hong");
	
	//한글이 깨질때 인코딩
	Cookie cookie = new Cookie("name",URLEncoder.encode("홍길동","utf-8"));
	
	//초단위로 얼마나 오래 쿠키를 유지할지 설정
	cookie.setMaxAge(10);
	
	
	

	//응답에 만든쿠키 추가
	response.addCookie(cookie);	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키 생성</title>
</head>
<body>
	쿠키이름 : <%=cookie.getName() %>
	쿠키 값 : <%=cookie.getValue() %>
	
</body>
</html>