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
<title>새글쓰기</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<!-- 	<div class="wrap" align="center"> -->
		<h2 align="center" class="text-warning">게시글 등록</h2>
		<form name="frm" action="board">
		<input type="hidden" name="command" value="board_write">
		<table align="center">
<div class="form-group row" >
	<div class="col-xs-2">
			<tr class="success">
				<th class="text-warning">제목</th>
				<td><input type="text" name="title" class="form-control" placeholder="제목을 입력해주세요"></td>
			</tr>
			<tr>
				<th class="text-warning">작성자</th>
				<td><input type="text" name="id" readonly="readonly" value="<%=request.getSession().getAttribute("id")%>" class="form-control"></td>
			</tr>
			<tr>
				<th class="text-warning">내용</th>
				<td>
					<textarea rows="15" cols="70" name="content" class="form-control" placeholder="내용을 입력해주세요"></textarea>
				</td>
			</tr>
	</div>
	</div>
		</table>
		<br>
		<div class="container" align="center">
		<input type= "submit" value="등록" class="btn btn-warning navbar-btn">
		<input type= "reset" value="다시작성" class="btn btn-warning navbar-btn">
		<input type="button" value="취소" onclick="location.href='board?command=board_list'" class="btn btn-warning navbar-btn">
		</div>
		</form>
</body>
</html>