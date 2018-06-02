package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req,resp);
	}
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//post방식은 한글이 깨진다. 요청을 젤 처음 받은곳에 인코딩해주면 한글이 안깨진다.
		req.setCharacterEncoding("utf-8");
		
		//요청에서 파라미터를 꺼내와서 전달
		//요청 자체가 포워딩 되면 요청의 파라미터는 그대로 사용가능
		req.getRequestDispatcher("07boardInfo.jsp").forward(req, resp);
	}
	
}
