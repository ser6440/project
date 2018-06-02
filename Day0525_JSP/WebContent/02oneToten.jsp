<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
	//선언부에 선언하게 되면 변환되는 서블릿의 멤버변수로 선언
	int sumNum;
	//숫자를 하나 받아서 1부터 입력받은 수 까지 합을 구하는 메서드
	public int sum(int num){
		int sum = 0;
		for(int i=1;i<=num;i++){
			sum +=i;
		}
		return sum;
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1부터 10까지</title>
</head>
<body>
	<%-- 1부터 10까지 더하는 프로그램을 작성
		스크립트 사용하기
		스크립트릿(scriptlet) <% %> 
		표현부(expression) <%= %>
		선언부(declaration) <%! %>
	 --%>
	 <%
	 	int sumNum = 0;
// 	 	for(int i=1;i<=10;i++){
// 	 		sumNum += i;
// 	 	}
	 	sumNum = sum(9);
	 %>
	 
	 1부터 10까지의 합은 <%= sumNum %>
	 
	 <br>
	 C:\Users\bit\workspace1\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\Day0525_JSP\org\apache\jsp
	 <%-- 두 숫자를 입력받아서 곱을 화면에 출력하는 multiply.jsp를 작성하세요--%>

</body>
</html>