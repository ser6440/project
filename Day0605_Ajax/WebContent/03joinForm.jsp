<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	/* form data 전송 */
	//form요소에 submit 이벤트가 발생했을 때, ajax요청 만들기
	$(function() {
		$("#memberForm").on("submit", function() {
			//폼 요소에 있는 데이터를 서버로 전송, ajax를 이용해서
			//폼 요소의 input을 전송가능한 형태로 변경

			//폼 요소에 데이터가 들어갈 객체 d $(this)는 이벤트가 발생한 요소
			var d = $(this).serialize();
			alert("d: " + d);

			$.ajax({
				url : "member",
				type : "get",
				data : d,
				dataType : "json",
				success : function(data) {

				}
			});
			return false; //submit의 진행을 멈춤
		});

		$("#userid").on("blur", function() {
// 						alert($(this).val());
			$.ajax({
				url : "member?command=checkId",
				type : "post",
				data : {
					"userid" : $(this).val()
				},
				dataType : "json",
				success : function(data) {
					//data를 확인하고 결과에 따라서  idResult 를 조작
									alert("data : " + data.result);
					var strResult;
					if (data.result) {
						strResult = '사용가능 아이디';
					} else {
						strResult = '이미 사용중인 아이디입니다.';
					}
					$("#idResult").text(strResult);
				}
			});
		});

	});

	//memberList.jsp
	//userid에서 포커스가 없어지면 ajax로 아이디가 사용가능한지 불가능한지 확인하기위한 요청
	//checkid요청 생성 >> 데이터베이스에서 해당아이디가 있는지 없는지확인 , 있으면 true 없으면 false를 반환
	//1. userid이벤트 핸들러 등록
	//2. 이벤트 핸들러에서 ajax요청
	//3. ajax결과를 이용해서 idResult텍스트 설정
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="hello" method="post" name="memberForm" id="memberForm">
		<fieldset>
			<legend>회원가입</legend>
			<p>
				아이디 : <input type="text" name="userid" id = "userid" ><span
					id="idResult"></span>
			</p>
			<p>
				이름 : <input type="text" name="name">
			</p>
			<p>
				이메일 : <input type="text" name="email">
			</p>
		</fieldset>
		<input type="submit">
	</form>
</body>
</html>