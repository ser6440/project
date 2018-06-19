<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>비밀번호 확인</title>
</head>
<body>
	게시글 번호 : ${param.num}
	<div class="form-group row" align="center">
		<h2 class="text-warning">비밀번호 확인</h2>
		<form action ="board" name="frm" method="post" align="center">
			<input type="hidden" name="command" value="board_check_pass">
			<input type="hidden" name="num" value="${param.num}">
			<table>
			<div class="col-xs-4">
			<div class="input-group">
		      <span class="input-group-addon" align="center"><i class="glyphicon glyphicon-lock"></i></span>
		      <input id="password" type="password" class="form-control" name="pass" placeholder="Password">
				</div>
			<input type="submit" value="확인" class="btn btn-warning navbar-btn"> 
			</div>
			
			</table>
		</form> 
	</div>
	${msg}
</body>
</html>