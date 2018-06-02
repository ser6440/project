<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="member" class="model.Member"/>
<%-- <jsp:setProperty property="id" name="member"/> --%>
<%-- <jsp:setProperty property="name" name="member"/> --%>
<%-- <jsp:setProperty property="email" name="member"/> --%>
<%-- <jsp:setProperty property="password" name="member"/> --%>
<%--
	위에 코드를 자바코드로
	member.setId(request.getParameter("id"));
--%>

<%-- 파라미터중 member의 필드명과 일치하는 파라미터가 있으면 모두 가져와서 해당 속성으로 설정--%>
<jsp:setProperty name="member" property="*"/>

<%-- 위에서 만든 member에 파라미터로 넘어오는 값 넣기 --%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- memberForm에서 입력한 정보 확인하는 페이지--%>
	<%--
		우리가 알던 파라미터 접근방법
		<% String id = request.getParameter("id"); %>
		<jsp:useBean>으로 Bean하나 만들고 해당하는 Bean에 파라미터 넣기
		
		파라미터 값 중에 "password"라는 이름을 가지는 파라미터가 있으면
		member.setPassword(파라미터)를 실행
		property는 setter이름
		<jsp:setProperty property="password" name="member"/>
	 --%>
	 
<%-- 	 <% String id = request.getParameter("id"); %> --%>
<%-- 	 id : <%=id %> --%>
	 
	 memberID : <%=member.getId() %>
	 memberPassword : <%=member.getPassword() %>
	 memberName : <%=member.getName() %>
	 memberEmail : <%=member.getEmail() %>
</body>
</html>