package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardMemberDao;
import dao.BoardMemberDaoImp;
import model.BoardMember;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		HttpSession session = req.getSession();
		
		BoardMemberDao dao = BoardMemberDaoImp.getInstance();
		BoardMember bm = dao.selectOne(id);
		String url = "";
		
		if(id.equals(bm.getId()) && pw.equals(bm.getPw())) {
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			session.setAttribute("loginuser", bm);
			
//			req.setAttribute("url", "loginSuccess.jsp");
			url = "loginSuccess.jsp";
		}else {
//			req.setAttribute("url", "loginForm.jsp");
			
			url = "login.jsp";
			req.setAttribute("msg", "로그인 실패");
			req.getRequestDispatcher("result.jsp").forward(req, resp);
		}
		req.getRequestDispatcher(url).forward(req, resp);

	}
}
