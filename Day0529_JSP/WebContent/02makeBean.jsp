<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Member" %>
    <%-- 
    	빈(bean)객체 하나 만들어서 포워드
    --%>
    <jsp:useBean id="member" class="model.Member" scope="request"></jsp:useBean>
    <jsp:setProperty property="address" name="member" value="서초구"/>
    
    <%
//     	Member member = new Member();	
//     	request.setAttribute("member", member);
    	member.setAddress("서초구");
    	member.setId("bitcamp");
    	member.setName("홍길동");
    %>
    <jsp:forward page="02useBean.jsp"/>
    
    <%--
    	<jsp:useBean id="s1" class="Student" scope="request">
    	javaBean: javaBean 규약에 의해서 만들어진 클래스로 생성한 객체
    	
    	id = "" bean의 인스턴스 이름, Student s1 = new Student();
    	class : bean 객체의 참조 클래스
    	scope : bean 라이프 사이클 관리
    			(default = page,request,session,application)
    			
		<jsp:setProperty> : 빈의 속성을 설정하는 액션태그
		name : 속성 지정하고자 하는 bean의 식별자(id)
		property : 설정하고자하는 bean의 속성이름(setter의 이름)
		value : 설정하고자하는 값
		
		<jsp:getProperty> : 빈 객체의 속성을 가져오는 액션태그
		    			
     --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>액션태그 Bean</title>
</head>
<body>

</body>
</html>