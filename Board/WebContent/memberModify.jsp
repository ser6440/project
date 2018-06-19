<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>정보 수정</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr>
	<div class="wrap" align="center">
	<h2 class="text-warning">정보 수정</h2>
		<form name="frm" action="member">
		<input type="hidden" name="command" value="memberModify">
<%-- 		<input type="text" name="num" value="${param.num}"> --%>
		<table>
		
		<div class="form-group row">
			<div class="col-xs-2">
	
			<tr>
				<th class="text-warning">아이디</th>
				<td><input type="text" name="id" readonly="readonly" value="<%=request.getSession().getAttribute("id")%>" class="form-control"></td>
			</tr>
			<tr>
				<th class="text-warning">이름</th>
				<td><input type="text" name="name" class="form-control"></td>
			</tr>
			<tr>
				<th class="text-warning">비번</th>
				<td><input type="password" name="pw" class="form-control"></td>
			</tr>
			<tr>
				<th class="text-warning">이메일</th>
				<td><input type="text" name="email" class="form-control"></td>
			</tr>
				</div>
			</div>
		</table>
		<br>
		<div class="container" align="center" class="btn btn-warning navbar-btn">
		<input type= "submit" value="수정하기" class="btn btn-warning navbar-btn">
		<input type= "reset" value="다시작성" class="btn btn-warning navbar-btn">
		</div>
	</div>
		</form>
</body>
</html>