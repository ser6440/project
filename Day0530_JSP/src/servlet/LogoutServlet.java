package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req,resp);
	}
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//userid라는 이름의 쿠키 만들어서 응답하면됨
		//loginForm으로 redirect
		Cookie newCookie = new Cookie("userid","");
		newCookie.setMaxAge(0);
		resp.addCookie(newCookie);
		resp.sendRedirect("04loginForm.jsp");
		
	}
}
