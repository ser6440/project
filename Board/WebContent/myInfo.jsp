<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/board.js"></script>
<title>마이페이지</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	
	<div class="container" align="center">
		<h2 class="text-warning">마이페이지 </h2>
		<table class="table table-condensed">
			<tr>
				<th class="success">아이디</th>
				<th><%=session.getAttribute("id") %></th>
			</tr>
			<tr>
				<th class="success">이름</th>
				<th>${boardmember.name}</th>
			</tr>
			<tr>
				<th class="success">이메일</th>
				<th>${boardmember.email}</th>
			</tr>
			<tr>
				<th class="success">가입일</th>
				<th>${boardmember.regDate}</th>
			</tr>
		</table>
		<br><br><br>
		<input type="button" value="수정" 
		class="btn btn-warning navbar-btn" onclick="open_win('member?command=member_check_pass_form&num=${boardmember.num}','update')">
<!-- 		<input type="button" value="수정" onclick="location.href='member?command=memberModify'"> -->
		<input type="button" value="탈퇴" 
		class="btn btn-warning navbar-btn" onclick="open_win('member?command=member_check_pass_form&num=${boardmember.num}','delete')">
	</div>
</body>
</html>