<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	<div class="container">
<!-- <div id = "wrap"> -->
		<p>
		<c:if test="${empty sessionScope.id}">
			<button type="button" class="btn btn-primary" value="홈" onclick="location.href='member?command=homeForm'">홈</button>
			<input type="button" value="로그인" onclick="location.href='member?command=loginForm'" class="btn btn-primary">
		</c:if>
	
		<!-- // 로그인 되었을 경우 - 로그아웃, 내정보 버튼을 보여준다. -->
		<c:if test="${not empty sessionScope.id}">
			<input type="button" value="홈" onclick="location.href='member?command=homeForm'" class="btn btn-primary">
			<input type="button" value="로그아웃" onclick="location.href='member?command=logout'" class="btn btn-primary">
			<input type="button" value="게시판" onclick="location.href='board?command=board_list'" class="btn btn-primary">
			<input type="button" value="마이페이지" onclick="location.href='member?command=myInfo'" class="btn btn-primary">
		</c:if>
		</p>
	</div>
	--%>
	
		<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" class="active" href="#">HomePage</a>
    </div>
    <c:if test="${empty sessionScope.id}">
    <ul class="nav navbar-nav">
      <li><a href="member?command=homeForm">Home</a></li>
      <li><a href="member?command=loginForm">Login</a></li>
      </ul>
    </c:if>
    <c:if test="${not empty sessionScope.id}">
    <ul class="nav navbar-nav">
      <li><a href="member?command=homeForm">Home</a></li>
      <li><a href="member?command=logout">Logout</a></li>
     <li><a href="board?command=board_list">Board</a></li>
      <li><a href="member?command=myInfo">MyPage</a></li>
    </c:if>
  </div>
</nav>
</body>
</html>