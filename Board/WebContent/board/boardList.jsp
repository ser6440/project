<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>게시판</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
			<tr align="left">
				<td colspan="5">
<!-- 					<a href="board?command=board_write_form">게시글 등록</a> -->
						<input type=button value="글쓰기" onclick="location.href='board?command=board_write_form'" class="btn btn-default navbar-btn">
				</td>
			</tr>
			</div>
	<div class="container" align="center">
		<table class="table table-bordered">
			<tr class="success">
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			
			<c:forEach items="${viewData.boardList}" var="board2">
				<tr class="warning">
					<td>${board2.num}</td>
					<td><a href="board?command=board_view&num=${board2.num}">${board2.title}</a></td>
					<td>${board2.id}</td>
					<td>${board2.writeDate}</td>
					<td>${board2.readCount}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<c:if test="${viewData.startPage != 1 }">
		<a href="board?command=board_list&page=1">[처음]</a>
		<a href="board?command=board_list&page=${viewData.startPage-1}">[이전]</a>
	</c:if>
	<c:forEach var = "pageNum" begin="${viewData.startPage}" end="${viewData.endPage < viewData.pageTotalCount ? viewData.endPage : viewData.pageTotalCount}">
		<c:choose>
			<c:when test="${pageNum == viewData.currentPage}">
			<b>[${pageNum}]</b>
			</c:when>
			<c:otherwise>
				<a href="board?command=board_list&page=${pageNum}">[${pageNum}]</a>	
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${viewData.endPage < viewData.pageTotalCount}">
		<a href="board?command=board_list&page=${viewData.endPage+1}">[다음]</a>
		<a href="board?command=board_list&page=${viewData.pageTotalCount}">[마지막]</a>
	</c:if>
	</div>
</body>
</html>