package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/colorSelect")
public class ColorServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("color");
		
		switch(param) {
		case "1":
			req.setAttribute("msg", "빨강");
			req.setAttribute("msg", "red");
			break;
		case "2":
			req.setAttribute("msg", "파랑");
			req.setAttribute("msg", "blue");
			break;
		case "3":
			req.setAttribute("msg", "초록");
			req.setAttribute("msg", "green");
			break;
		}
		req.getRequestDispatcher("04colorSelect.jsp").forward(req, resp);
	}

}
