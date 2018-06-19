package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardMemberDao;
import dao.BoardMemberDaoImp;
import model.BoardMember;

public class MemberModifyAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardMemberDao bmd = BoardMemberDaoImp.getInstance();
		
		
		System.out.println("num : " + req.getParameter("num"));
		BoardMember bm = new BoardMember();
		
		
		bm.setId(req.getParameter("id"));
		bm.setName(req.getParameter("name"));
		bm.setPw(req.getParameter("pw"));
		bm.setEmail(req.getParameter("email"));
		
		System.out.println("수정한 친구의 넘 : "+bm);
		
		int result = bmd.updateBoardMember(bm);
		String url = "";
		
		if(result > 0 ) {
			req.setAttribute("msg", "수정완료");
			url = "myInfo";
		}else {
			req.setAttribute("msg", "수정실패");
			url = "memberModify";
		}
		req.setAttribute("url", url);
		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}

}
