package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dao.BoardDaoImp;
import dao.BoardMemberDao;
import dao.BoardMemberDaoImp;
import model.Board;
import model.BoardMember;

public class BoardCheckPassAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num = req.getParameter("num");
		String pw = req.getParameter("pass");
		HttpSession session = req.getSession();
		String pass = (String) session.getAttribute("pw");

		
		BoardDao dao = BoardDaoImp.getInstance();
		Board board = dao.selectOne(num);
//		BoardMemberDao bmd = BoardMemberDaoImp.getInstance();
//		BoardMember bm = bmd.selectOne(num);
		String url = "";
		
		
		System.out.println(pw);
		System.out.println(pass);
		if(pass.equals(pw)) {
			//비밀번호같으면 수정가능
			url = "board/checkSuccess.jsp";
		}else {
			//비밀번호틀리면 비밀번호 다시 입력
			url = "board/boardCheckPass.jsp";
			req.setAttribute("msg", "비밀번호가 일치하지 않습니다");
		}
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
