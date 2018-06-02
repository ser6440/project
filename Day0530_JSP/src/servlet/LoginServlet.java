package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	String myId = "dlduswn";
	String myPw = "1234";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req,resp);
	}
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userid");
		String pw = req.getParameter("userpw");
		
		String url = "04loginForm.jsp";
		if(id != null && id.equals(myId)) {
			if(pw != null && pw.equals(myPw)) {
				//아이디와 비번일치하면, 로그인상태로 설정
				//쿠키생성해서 브라우저로 주기
				Cookie cookie = new Cookie("userid",id);
				resp.addCookie(cookie);
				url = "main";
			}else {
				
			}
		}else {
			
		}
		resp.sendRedirect(url);
	}
	
}
