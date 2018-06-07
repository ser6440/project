<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
  
<script type="text/javascript">
	 function doAjax(){
		 var d = "Hello Server!!";
		 $.ajax({
			 url : "hello",                        
			 type : "post",
			 data : {"d" : d},
			 dataType : 'json',
			 success : function(data){
				 alert("data.msg : " + data.msg);
				$("#txt1").text(data.msg);
			 },
			 error : function(request,status,error){
				 alert("request : " + request + "\n" 
					  + "status : " + status  + "\n"
					  +  "error : " + error   + "\n");
			 }
		 });
	 }
</script>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 id="txt1">
	</h1>
	<button onclick="doAjax();">요청</button>
</body>
</html>