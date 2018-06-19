package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardMemberDao;
import dao.BoardMemberDaoImp;
import model.BoardMember;

public class MyInfoAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "myInfo.jsp";
		BoardMemberDao bmd = BoardMemberDaoImp.getInstance();
//		String id = req.getParameter("id");
		HttpSession session = req.getSession();
	
	    String id = (String) session.getAttribute("id");
	    System.out.println(id);
	    
		BoardMember bm = bmd.selectOne(id);
		System.out.println(bm);
		
		req.setAttribute("boardmember", bm);
		req.getRequestDispatcher(url).forward(req, resp);
		
	}

}
