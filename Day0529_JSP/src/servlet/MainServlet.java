package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main")
public class MainServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req,resp);
	}
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		System.out.println("메인 요청입니다!!");
		/*
		 * 로그인이 되어있으면, main.jsp로 포워드
		 * 로그인이 되어있지않으면 loginForm.jsp로 Redirect
		 * 
		 */
		//로그인 여부 판단 : session속성에 userid 속성이 있으면 로그인 상태
		HttpSession session = req.getSession();
		if(session.getAttribute("userid") != null) {
			// 로그인 상태
			req.getRequestDispatcher("04main.jsp").forward(req, resp);
		}else {
			//비로그인 상태
			resp.sendRedirect("04loginForm.jsp");
		}
		
	}
}
