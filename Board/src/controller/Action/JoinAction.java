package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardMemberDao;
import dao.BoardMemberDaoImp;
import model.BoardMember;

public class JoinAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardMemberDao bmd = BoardMemberDaoImp.getInstance();
		HttpSession session = req.getSession();
		
		BoardMember bm = new BoardMember();
		bm.setId(req.getParameter("id"));
		bm.setName(req.getParameter("name"));
		bm.setPw(req.getParameter("pw"));
		bm.setEmail(req.getParameter("email"));
		
		System.out.println(bm);
		int result = bmd.insertBoardMember(bm);
		
//		String id = req.getParameter("id");
//		String name = req.getParameter("name");
//		String email = req.getParameter("email");
//		String reg_date = req.getParameter("reg_date"); 
		
		if(result > 0) {
			req.setAttribute("msg", "회원가입완료");
//			session.setAttribute("id", id);
//			session.setAttribute("name", name);
//			session.setAttribute("email", email);
//			session.setAttribute("reg_date", reg_date);
		}else {
			req.setAttribute("msg", "회원가입실패");
		}
		req.setAttribute("url", "loginForm");
		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}

}
