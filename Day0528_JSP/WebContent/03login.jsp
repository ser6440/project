<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 화면</title>
</head>
<body>
	 <form action="login" method="POST">
	 	<p>
	 	<label>아이디<input type="text" name="userid" ></label>
	 	</p>
	 	<p>
	 	<label>비밀번호<input type="password" name="userpw" ></label>
	 	</p>
	 	<p>
	 	<input type="submit" value="로그인">
	 	</p>
	 </form>
</body>
</html>