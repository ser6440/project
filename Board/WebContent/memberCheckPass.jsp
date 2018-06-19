<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<!-- 		<div class="form-group row"> -->
	<div class="form-group row" align="center">
	
		<h2 class="text-warning">비밀번호 확인</h2>
		<form action ="member" name="frm" method="post">
			<input type="hidden" name="command" value="member_check_pass">
			<input type="hidden" name="num" value="${param.num}">
			
<!-- 				<td>비밀번호</td> -->
<!-- 				<td><input type="password" name="pw" size="20"></td> -->

		      
			<div class="col-xs-4" align="center">
			<div class="input-group">
		      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
		      <input id="password" type="password" class="form-control" name="pw" placeholder="Password">
				</div>
			</div>
			<input type="submit" value="확인" class="btn btn-warning navbar-btn"> 
			
		</form> 
	</div>

	${msg}
</body>
</html>