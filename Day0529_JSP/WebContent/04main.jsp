<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--  로그인 성공하면 id를 session에 attribute로 저장--%>
	<%=session.getAttribute("userid") %>님 반갑습니다.<br>
	<button onclick = "location.href='logout'">로그아웃</button>
</body>
</html>