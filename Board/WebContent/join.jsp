<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>회원가입</title>
<script type="text/javascript">
$(function() {
	$("#id").on("blur", function() {
			$.ajax({
				url : "member?command=CheckId",
				data : {
					"id" : $(this).val()
				},
				dataType : "json",
				success : function(data) {
					if (data.result) {
						/*checkId = true;*/
						$("#idDup").text("사용가능아이디");
					} else {
						$("#idDup").text("사용불가 아이디");
					}
				}
			});
		});
	});
</script>
</head>
<body>
<jsp:include page="header.jsp"/>

	<form action="member" method="post">
		<input type="hidden" name = "command" value = "join">
		<h2 align="center" class="text-warning">회원가입</h2>
		<table align="center">
	<div class="form-group row">
	<div class="col-xs-2">
<!-- 		<p><label>아이디:<input type="text" name = "id" class="form-control" placeholder="ID"></label></p> -->
<!-- 		<p><label>비&nbsp;&nbsp;&nbsp;번:<input type="password" name = "pw" class="form-control" placeholder="PASSWORD"></label></p> -->
<!-- 		<p><label>이&nbsp;&nbsp;&nbsp;름:<input type="text" name = "name" class="form-control" placeholder="NAME"></label></p>  -->
<!-- 		<p><label>이메일:<input type="text" name = "email" class="form-control" placeholder="EMAIL"></label></p> -->
<!-- 		<input type="submit" value="회원가입" class="btn btn-warning navbar-btn"> -->
<!-- 		<input type="reset" value="다시작성" class="btn btn-warning navbar-btn"> -->
		<tr>
		<th class="text-warning">아이디</th>
		<td><input type="text" name = "id" id="id" class="form-control" placeholder="ID"></td>
		<td><span id="idDup">아이디 중복 여부</span></td>
		</tr>
		<tr>
		<th class="text-warning">비밀번호</th>
		<td><input type="password" name = "pw" class="form-control" placeholder="PASSWORD"></td>
		</tr>
		<tr>
		<th class="text-warning">이&nbsp;&nbsp;&nbsp;름</th>
		<td><input type="text" name = "name" class="form-control" placeholder="NAME"></td>
		</tr>
		<tr>
		<th class="text-warning">이메일</th>
		<td><input type="text" name = "email" class="form-control" placeholder="EMAIL"></td>
		</tr>
		</div>
		</div>
		</table>
		<div class="container" align="center">
		<input type="submit" value="회원가입" class="btn btn-warning navbar-btn"> 
		<input type="reset" value="다시작성" class="btn btn-warning navbar-btn">
		</div>
	</form>
</body>
</html>