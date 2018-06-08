<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	//비밀번호가 맞았을 때, 
	//update : 팝업화면에서 계속 요청진행이 아니라 큰 화면에서 요청을 진행 하도록 하는기능
	//delete : 삭제 요청 만들면됨
	if(window.name=="update"){
		window.opener.parent.location.href="board?command=board_update_form&num=${param.num}";	
	}else if(window.name=="delete"){
		window.opener.parent.location.href="board?command=board_delete&num=${param.num}";
	}
	//창 꺼주기
	window.close();	
</script>