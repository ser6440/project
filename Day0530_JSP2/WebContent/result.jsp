<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 결과 경고창으로 출력, 다음 화면으로 이동시키기 --%>
<script type="text/javascript">
	alert("<%=request.getAttribute("msg")%>");
	//다음 화면으로 이동하는 요청만들기 
	location.href="<%=request.getAttribute("url")%>";
</script>
