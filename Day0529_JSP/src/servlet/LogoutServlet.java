package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		 //1. session에서 'userid' 속성 지우고
		 //2. loginForm.jsp로 redirect
		 
		 resp.setCharacterEncoding("utf-8");	//한글처리
		 req.setCharacterEncoding("utf-8");		//한글처리
		 HttpSession session = req.getSession();
		 session.removeAttribute("userid");
		 resp.sendRedirect("04loginForm.jsp");
	}
}
