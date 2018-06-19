<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/board.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 상세보기</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr>
	<div class="container" align="center">
		<h2 class="text-warning">게시글 상세보기</h2>
		<table class="table table-condensed">
			<tr> 
				<th class="success">작성자</th>
				<th>${board2.id}</th>
			</tr>
			<tr>
				<th class="success">작성일</th>
				<th>${board2.writeDate}</th>
			</tr>
			<tr>
				<th class="success">조회수</th>
				<th>${board2.readCount}</th>
			</tr>
			<tr>
				<th class="success">내용</th>
				<td colspan="3">${board2.content}</td>
			</tr>
		</table>
		
		<div class="container" align="center" class="btn btn-warning navbar-btn">
		<input type="button" value="수정" onclick="open_win('board?command=board_check_pass_form&num=${board2.num}','update')" class="btn btn-warning navbar-btn">
		<input type="button" value="삭제" onclick="open_win('board?command=board_check_pass_form&num=${board2.num}','delete')" class="btn btn-warning navbar-btn">
		<input type="button" value="목록" onclick="location.href='board?command=board_list'" class="btn btn-warning navbar-btn">
		<input type="button" value="새글쓰기" onclick="location.href='board?command=board_write_form'" class="btn btn-warning navbar-btn">
		
		<c:forEach var="reply" items="${replyList}">
			<tr>
				<td>
					<div>
						${reply.id}<br>
						<font size="2" color="lightgray">${reply.writeDate}</font>
					</div>
				</td>
				<td>
					<div>
						${reply.content}
					</div>
				</td>
				<td>
					<div>
						<c:if test="${reply.id == sessionScope.id}">
<!-- 							<a href="#">수정</a> -->
<!-- <a href="board?command=board_write_form"> -->
							<a href="board?command=replyDelete&rNum=${reply.rNum }&num=${board2.num}">삭제</a>
						</c:if>
					</div>
				</td>
			</tr>
		</c:forEach>
		
<!-- 		<table border="1"> -->
<!-- 			<td width="150"> -->
<!-- 				<div> -->
<%-- <%-- 					${sessionScope.id} --%> 
<%-- <%-- 						<%=request.getSession().getAttribute("id") %> --%> 
<%-- 						<input type="text" name="id" readonly="readonly" value="<%=request.getSession().getAttribute("id")%>"> --%>
<!-- 				</div> -->
<!-- 			</td> -->
<!-- 			<td> -->
<!-- 				<div> -->
<!-- 					<textarea name="contents" rows="4" cols="70"></textarea> -->
<!-- 				</div> -->
<!-- 			</td> -->
<!-- 		</table> -->
<!-- 			<td width="100"> -->
<!-- 				<div> -->
<%-- 					<input type="button" value="댓글등록" onclick="location.href='board?command=reply&id=${id}&contents=${contents }'" class="btn btn-warning">  --%>
<!-- 				</div> -->
<!-- 			</td> -->
<!-- 	</div> -->
<!-- 	</div> -->
	
	
	
	
	
	
	<form name="frm" action="board">
	<input type="hidden" name="command" value="reply">
	<input type="hidden" name="num" value="${board2.num}">
	<table border="1" align="center">
	<tr>
			<td width="150">
				<div>
<%--  					${sessionScope.id}  --%>
<%-- 						<%=request.getSession().getAttribute("id") %> --%>
						<input type="text" name="id" readonly="readonly" value="<%=request.getSession().getAttribute("id") %>">
				</div>
			</td>
			<td>
				<div>
					<textarea name="content" rows="4" cols="70"></textarea>
				</div>
			</td>
			<td width="100">
				<div>
					<input type="submit" value="댓글등록" class="btn btn-warning"> 
				</div>
			</td>
			</tr>
		</table>
		</form>
</body>
</html>