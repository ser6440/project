<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--
    	<jsp:forward> 사용해보기
    	
    	넘어온 파라미터의 값에 따라서 적절한 페이지로 포워딩
    	
     --%>
     <%request.setCharacterEncoding("utf-8"); %>
     <%
     	//파라미터 받아오기
     	String color = request.getParameter("color");
     	String url = null;
     	if(color.equals("red")){
     		//빨강으로 이동
     		url = "01red.jsp";
     	}else if(color.equals("blue")){
     		//파랑으로 이동
     		url = "01blue.jsp";
     	}else if(color.equals("yellow")){
     		//노랑으로 이동
     		url = "01yellow.jsp";
     	}
     	
     	
     	
     	//원래 포워드 하려면
//      	RequestDispatcher dispatcher = request.getRequestDispatcher("url");
//      	dispatcher.forward(request,response);
     %>
     <%-- 액션태그로 포워드하기
     자바코드에서 가져온 페이지 url을 넣어준다--%>
     <jsp:forward page="<%=url %>">
     <jsp:param value="홍길동" name="name"/>
     </jsp:forward>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>action Forward</title>
</head>
<body>
	
</body>
</html>