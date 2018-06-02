<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키삭제</title>
</head>
<body>
	<%
	/* 쿠키 지우기
		쿠키는 브라우저가 관리하기 때문에 서버에서는 직접 관여할 수 없다
		같은 이름의 쿠키 만들어내고 maxAge를 0으로 설정
	*/
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length>0){
			for(int i=0;i<cookies.length;i++){
				if(cookies[i].getName().equals("name")){
					//지우는 방법
					//원래 있던 쿠키와 동일한 이름의 쿠키를 만들어내고 
					//그 쿠키의 유효시간을 0으로 만든다.
					Cookie newCookie = new Cookie("name","");
					newCookie.setMaxAge(0);
					//응답에 담아주기 브라우저가 쿠키를 들고있기때문에
					response.addCookie(newCookie);
				}
			}
		}
	%>
</body>
</html>