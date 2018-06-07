<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	/* 
		비동기 방식으로 요청/처리하기
		1. 아이디 확인
		2. 회원가입후 회원 목록 가져오기
		
	*/
			
	$(function(){
		$("#userid").on("blur",function(){
			$.ajax({
				url : "member?command=checkId",
				type : "post",
				data : {
					"userid" : $(this).val(),
				},
				dataType : "json",
				success : function(data){
					alert("data : " + data.result);
					var strResult;
					if(data.result){
						strResult = "사용가능 아이디";
					}else{
						strResult = "사용불가 아이디";
					}
					$("#idDup").text(strResult);
				}
			});
		});
		$("#email").on("blur",function(){
			$.ajax({
				url : "member?command=checkEmail",
				type : "post",
				data : {
					"email" : $(this).val()
				},
				dataType : "json",
				success : function(data){
					alert("data : " + data.result);
					var strResult;
					if(data.result){
						strResult = "사용가능 이메일";
					}else{
						strResult = "사용불가 이메일";
					}
					$("#emailDup").text(strResult);
				}
			});
		});
		
		//joinForm submit 이벤트 처리하기
		$("#joinForm").on("submit",function(){
			var d = $(this).serialize();
			$.ajax({
				url : "member?command=join",
				data : d,
				type : "post",
				dataType : "json",
				success : function(data){
					if(data.result){
						alert("회원가입성공");
						createList();
					}else{
						alert("회원가입실패");
					}
				}
			});
			return false;
		});
		//memberList요청이 들어오면 회원목록을 json
		//형태로 만들어서 출력
		//회원가입 눌렀을 때 화면 전환없이 회원목록 변경하기(비동기적으로 회원목록 데이터 변경하기)
		
		createList();
	});
	
	function createList(){
		//listTable 테이블에 회원 목록을 조회해서 출력하는 함수
		//ajax 요청
		//반환된 데이터를 tr,td 요소 만들어서 갖다 붙임
		
		var table = $("#listTable");
		
		$("#listTable tr:gt(0)").remove();
		
		$.ajax({
			url : "member?command=memberList",
			type : "get",
			dataType : "json",
			success : function(data){
				//memberList 데이터를 가지고 있는 json객체를 반환받아서 처리
				for(var i in data){
					//반복문 반복 하면서 데이터를 테이블에 추가하기
					//테이블에 tr
					//tr에 td추가
					var tr = $("<tr>");
					var btn = $("<input type='button' value='삭제'>");	//삭제 버튼요소 만들기
					
					$("<td>").text(data[i].id).appendTo(tr);	//appendTo 자식요소가 부모요소에 붙는다
					$("<td>").text(data[i].email).appendTo(tr);
					$("<td>").text(data[i].name).appendTo(tr);
					$("<td>").append(btn).appendTo(tr);	//append 부모요소로서 자식요소를 가진다.
					tr.appendTo(table);
					
					//삭제요청
					//member?command=delete
					//for문 다 돌고 마지막 인덱스의 i가 출력되서 data[i].id의 i는 마지막 인덱스의 값이 나오므로 즉시 실행함수로 감싸준다.
					//즉시실행함수
					//(function(m){
					//	
					//})(i);
					(function(m){
						btn.on("click",function(){
							$.ajax({
								url : "member?command=delete",
								data : {"id":data[m].id},	//특정한 한줄을 지우기 위해 아이디의 속성을 준다(id로 지우기위해), id는  data[i].id가 가지고 있다.
								type : "post",
								dataType : "json",
								success : function(data){
									alert(data.result);
									//삭제하고 나면 목록이 새롭게 그려져야하니까 createList호출
									createList();
								}
							});
						});
						
					})(i);
					
				}
			}
		});
		
	}
</script>
</head>
<body>
	<form name="joinForm" method="post" id="joinForm" action="">
		<table border=1 >
			<tr bgcolor="olive">
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				
			</tr>
			<tr>
				<td><input type="text" name="userid" id="userid"><span id="idDup">아이디 중복 여부</span></td>
				<td><input type="password" name="password" id="password"></td>
				<td><input type="text" name="name" id="name"></td>
				<td><input type="text" name="email" id="email"><span id="emailDup">이메일 중복 여부</span></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="가입하기" id="joinBtn"></td>
			</tr>
		</table>
	</form>
	<h2>회원 목록</h2>
	<table id="listTable" border="1">
		<colgroup>
			<col width="150px">
			<col width="250px">
			<col width="100px">
		</colgroup>
		<tr bgcolor="olive">
			<th>아이디</th>
			<th>이메일</th>
			<th>이름</th>
			<th>삭제</th>
		</tr>
		<c:forEach items = "${viewData.memberList}" var="message">
		<tr>
			<td>${message.id}</td>
			<td>${message.email}</td>
			<td>${message.name}</td>
			<td><button onclick = "location.href = ${message.id}">삭제</button></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>