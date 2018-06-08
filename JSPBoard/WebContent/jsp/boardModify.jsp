<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/board.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<div class="wrap" align="center">
	<h1>게시글 수정</h1>
		<form name="frm" action="board">
		<input type="hidden" name="command" value="board_update" >
		<input type="hidden" name="num" value="${board.num}">
		<table>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="name" readonly="readonly" value="${board.name}">*필수</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pass">*필수(게시글 수정,삭제시 필요합니다.)</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" value="${board.email}">*필수</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${board.title}">*필수</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="15" cols="70" name="content"></textarea>
				</td>
			</tr>
		</table>
		<br>
		<input type= "submit" value="수정하기">
		<input type= "reset" value="다시작성">
		<input type="button" value="목록" onclick="location.href='board?command=board_list'">
		</form>
	</div>
</body>
</html>