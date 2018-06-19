package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardMemberDao;
import dao.BoardMemberDaoImp;
import model.BoardMember;

public class MemberModifyFormAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "memberModify.jsp";
		System.out.println(req.getParameter("num"));
		req.getRequestDispatcher(url).forward(req, resp);
		
	}

}
