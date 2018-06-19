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
<title>게시글 수정</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr>
	<div class="wrap" align="center">
	<h2 class="text-warning">게시글 수정</h2>
		<form name="frm" action="board">
		<input type="hidden" name="command" value="board_update">
		<input type="hidden" name="num" value="${board2.num}">
		<table align="center">
		<div class="form-group row" >
	<div class="col-xs-2">
			<tr>
				<th class="text-warning">작성자</th>
				<td><input type="text" name="id" readonly="readonly" value="${board2.id}" class="form-control"></td>
			</tr>
			<tr>
				<th class="text-warning">제목</th>
				<td><input type="text" name="title" value="${board2.title}" class="form-control"></td>
			</tr>
			<tr>
				<th class="text-warning">내용</th>
				<td>
					<textarea rows="15" cols="70" name="content" class="form-control"></textarea>
				</td>
			</tr>
			</div>
	</div>
		</table>
		<br>
		<div class="container" align="center">
		<input type= "submit" value="수정하기" class="btn btn-warning navbar-btn">
		<input type= "reset" value="다시작성" class="btn btn-warning navbar-btn">
		<input type="button" value="취소" onclick="location.href='board?command=board_list'" class="btn btn-warning navbar-btn">
		</form>
	</div>
</body>
</html>