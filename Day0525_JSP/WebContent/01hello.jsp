<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello!!</h1>
	<%--jsp에서 주석처리
		날짜 출력 >>> 날짜 정보는 자바에서 가져올 수 있다.
		Date 객체를 만들면 됨
		값을 출력하기 위해서 표현부 사용<%=  %>
		jsp페이지 내부에서 외부 클래스를 import해서 사용하기 위해서는 디렉티브 사용
	 --%>
	오늘의 날짜는 : <%= new Date() %>
</body>
</html>