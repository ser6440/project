<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		border: 1px solid black;
		margin: 10px;
		padding: 10px;
	}
	td{
		text-align: center;
	}
</style>
</head>
<body>
	<form action="board">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
				<textarea rows="10" cols="30" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan=3>
				<input type="submit" name="전송">
				<input type="reset" name="초기화">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>