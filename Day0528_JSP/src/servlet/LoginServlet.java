package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	// 'login' 요청 받아서 처리, post방식으로
	String myId = "hong123";
	String myPw = "12345";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("진짜 받아지네요");
		
		//아이디랑 비밀번호 요청에서 꺼내와서 원래 가지고 있던 아이디랑 비밀번호 비교
		String id = request.getParameter("userid");
	    String pw = request.getParameter("userpw");
		   
		   if(id != null && id.equals(myId)){
				//아이디 있음
				if(pw != null && pw.equals(myPw)){
					//out.print("로그인 성공!!");
					//로그인 성공하면 화면 이동
					//화면이동 방법 두가지 있음
					//forward, redirect
					//redirect: 페이지 전환이 되는데 응답 객체가 브라우저에게 새로운 요청을 만들어 내게 하는 방법
					//응답객체 : response
					//브라우저가 요청을 새롭게 만들게 되면 url이 바뀜
//		 			response.sendRedirect("06loginSuccess.jsp");
					
					//id,pw 정보를 유지하고 싶다...
					//현재 요청을 유지하면서, 화면만 전환: forward
					//forward: 브라우저랑은 상관없이 서버내부에서 화면전환
					RequestDispatcher dispatcher = request.getRequestDispatcher("03loginSuccess.jsp");
					dispatcher.forward(request,response);
					
				}else{
//		 			out.print("비밀번호가 틀렸습니다.");
					request.setAttribute("msg", "비밀번호가 틀렸습니다.");
					RequestDispatcher dispatcher = request.getRequestDispatcher("03loginFail.jsp");
					dispatcher.forward(request,response);
				}
		   }else{
//		 		out.println("아이디가 틀렸습니다.");
				request.setAttribute("msg", "아이디가 틀렸습니다.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("03loginFail.jsp");
				dispatcher.forward(request,response);
			}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	
	
}
