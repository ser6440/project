package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardMemberDao;
import dao.BoardMemberDaoImp;
import model.BoardMember;

public class MemberDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		BoardMemberDao bmd = BoardMemberDaoImp.getInstance();
		int result = bmd.deleteBoardMember(id);
		String url = "result.jsp";
		
		if(result ==1) {
			session.invalidate();
			req.setAttribute("msg", "탈퇴완료");
			System.out.println("삭제");
		}else {
			req.setAttribute("msg", "탈퇴실패");
		}
		req.setAttribute("url", "homeForm");
		req.getRequestDispatcher(url).forward(req, resp);

	}

}
