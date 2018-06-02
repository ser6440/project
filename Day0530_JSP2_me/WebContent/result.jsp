<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 결과 경고차으로 출력, 다음 화면으로 이동시키기--%>
<<script type="text/javascript">
	alert("<%=request.getAttribute("msg")%>");
	//다음화면으로 이동하는 요청 만들기
	location.href = "<%=request.getAttribute("url")%>";
	//로그인 결과와 url은 서블릿에서 결정 서블릿에서 부터 넘어와야한다. 서블릿에 msg,url주기->if else 끝난시점에 result.jsp에 msg를 담아준다.유지된채로 넘어와야 하니까 포워드
	//url도 담아줘야한다.
	
	
	
</script>