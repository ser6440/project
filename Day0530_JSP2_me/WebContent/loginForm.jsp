<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="login" method="post">
	<table>
		<tr>
			<th>아이디: </th>
			<td><input type="text" name="userid"></td>
		</tr>
		<tr>
			<th>비밀번호: </th>
			<td><input type="password" name="userpw"></td>
		</tr>
		<tr><td><input type="submit" value="로그인"></td>
		</tr>
		<button onclick = "location.href='joinForm'">회원가입</button>
	</table>
	</form>
</body>
</html>