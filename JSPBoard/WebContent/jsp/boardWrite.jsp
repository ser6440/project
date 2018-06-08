<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/board.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>새글작성</title>
</head>
<body>
	<!-- 새글 쓰기 양식 작성 -->
	<div class="wrap" align="center">
		<h1>게시글 등록</h1>
		<form name="frm" action="board">
		<input type="hidden" name="command" value="board_write" >
		<table>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="name">*필수</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pass">*필수(게시글 수정,삭제시 필요합니다.)</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email">*필수</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title">*필수</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="15" cols="70" name="content"></textarea>
				</td>
			</tr>
		</table>
		<br>
		<input type= "submit" value="등록">
		<input type= "reset" value="다시작성">
		<input type="button" value="목록" onclick="location.href='board?command=board_list'">
		</form>
	</div>
</body>
</html>