<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>빨간페이지</title>
</head>
<body bgcolor="red">
	이 페이지는 red.jsp입니다.
	색깔 파라미터: <%=request.getParameter("color") %><br>
	jsp:param : <%=request.getParameter("name") %><br>
</body>
</html>