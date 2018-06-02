<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="board" class="model.Board"/>    
<jsp:setProperty name="board" property="*"/>
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
</style>
</head>
<body>
	<form>
		<table>
			<tr>
				<th>제목 </th><td><%=board.getTitle() %></td>
			</tr>
			<tr>
				<th>작성자 </th><td><%=board.getName() %></td>
			</tr>
			<tr>
				<th>이메일</th><td><%=board.getEmail() %></td>
			</tr>
			<tr>
				<th>비밀번호</th> <td><%=board.getPass() %></td>
			</tr>
			<tr>
				<th>내용</th> <td><%=board.getContent() %></td>
			</tr>
</table>
</form>	
</body>
</html>