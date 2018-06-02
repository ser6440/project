<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>gugudan</title>
</head>
<body>
	<%-- 화면에 구구단 출력하기
		2 X 1 = 2
		2 X 1 = 4
		2 X 1 = 6
		2 X 1 = 8
	 --%>
	 <%
		 for(int i=2;i<10;i++){
			 //출력
			 %>
			 <h1><%=i%>단</h1>
			 <% 
			for(int j=1;j<10;j++){
				//출력
			%>
				<%=i %> X <%=j %>=<%=i*j%><br>
			<%
			}
		 }
	 %>
	 <%
	 	for(int i=2;i<=9;i++){
	 		out.write("<h1>"+i+"단</h1>");
	 		for(int j=1;j<=9;j++){
	 			out.write(i+"X"+j+"="+i*j+"<br>");
	 		}
	 	}
	 %>
	 
</body>
</html>