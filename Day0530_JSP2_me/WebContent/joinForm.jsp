<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="join" method="post">
	<table>
		<tr>
			<th>아이디: </th>
			<td><input type="text" name="userid"></td>
		</tr>
		<tr>
			<th>이름: </th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>비밀번호: </th>
			<td><input type="password" name="userpw"></td>
		</tr>
		<tr>
			<th>이메일: </th>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td><input type="submit" value="회원가입"></td>
			<td><input type="reset" value="다시작성"></td>
		</tr>
	</table>
	</form>
</body>
</html>