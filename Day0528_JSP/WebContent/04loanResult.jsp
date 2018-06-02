<%@page import="model.Loan"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loan Result</title>
<style type="text/css">
	table,td,th{
		border: 1px solid black;
		border-collapse: collapse;
		text-align: center;
		
	}
	table{
		margin: 0px auto;
	}
</style>
</head>
<body>
	<%-- 요청에 포함된 파라미터를 받아와서, 데이터 기준으로 표만들기
	 --%>
	 <% List<Loan> loanList = (List<Loan>)request.getAttribute("loanList");%>
	<table>
		<tr>
			<th>회차</th>
			<th>상환액</th>
			<th>상환원금</th>
			<th>이자</th>
			<th>상환총액</th>
			<th>대출잔액</th>
		</tr>
		
		<!-- tr 생성 부분을 for문으로 작성(입력한 회차만큼 테이블이 생기므로) -->
		<%
			//변수선언
// 			상환액 : repayTotal :월 상환원금+월 이자
// 			상환원금: repayOrigin :월 상환원금
// 			이자: interest : 이자금액
// 			상환총액 : repaySum : 상환누적금액 
// 			대출잔액 : repayRemain: 원금-상환원금 총액

			//원금 균등상환 : repayMonth + 이자
			//원리금 균등상환 : repayMonth
			
			for(int i=0;i<loanList.size();i++){
				Loan loan = loanList.get(i);
				%>
				<tr>
					<td><%=i+1 %></td>
					<td><%= loan.getRepayTotal()%></td>
					<td><%=loan.getRepayOrigin() %></td>
					<td><%=loan.getInterest() %></td>
					<td><%=loan.getRepaySum() %></td>
					<td><%=loan.getRepayRemain() %></td>
				</tr>
				<%
			}
		%>
	</table>
</body>
</html>