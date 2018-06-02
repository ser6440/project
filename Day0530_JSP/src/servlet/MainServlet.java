package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Cookie[] cookies = req.getCookies();
		String url = "04loginForm.jsp";
		
		if(cookies != null && cookies.length>0){
			for(int i=0;i<cookies.length;i++){
				if(cookies[i].getName().equals("userid")){
					//로그인상태
					//여기서 바로 sendRedirect해버리면 반복문 이니까 문제가 생길 수 있으니
					//sendRedirect는 한번만
					url = "04main.jsp";
				}
			}
		}
		resp.sendRedirect(url);
	}
}
