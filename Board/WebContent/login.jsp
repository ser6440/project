<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>로그인</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<form action="member" method="post">
	<input type="hidden" name = "command" value = "login">
	
	<div class="col-xs-2">
	<div class="input-group">
	<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	<input type="text" name="id" class="form-control" placeholder="ID"><br>
	</div>
	</div>
      
	<div class="col-xs-2">
	<div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      <input id="password" type="password" class="form-control" name="pw" placeholder="Password">
		</div>
	</div>
      <input type="submit" value = "로그인" onclick="location.href='member?command=loginSuccess'" class="btn btn-warning">
	  <input type="button" value = "회원가입" onclick="location.href='member?command=joinForm'" class="btn btn-warning">
	
	
<!--       <div class="container" align="center"> -->
<!-- 		</div> -->
<!-- 		<label>아이디 : <input type="text" name="id"></label><br> -->
<!-- 		<label>비밀번호 : <input type="password" name="pw"></label><br> -->
<!-- 		<input type="submit" value = "로그인" onclick="location.href='member?command=loginSuccess'"> -->
<!-- 		<input type="button" value = "회원가입" > -->
<!-- 		onclick="location.href='member?command=joinForm'">	 -->
	</form>
</body>
</html>