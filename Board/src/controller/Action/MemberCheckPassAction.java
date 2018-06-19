package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardMemberDao;
import dao.BoardMemberDaoImp;
import model.BoardMember;

public class MemberCheckPassAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("확인");
		String num = req.getParameter("num");
		String pass = req.getParameter("pw");
		HttpSession session = req.getSession();
		String pw = (String) session.getAttribute("pw");

		
		System.out.println("확인1");
		BoardMemberDao bmd = BoardMemberDaoImp.getInstance();
		BoardMember bm = bmd.selectOne(num);
		String url = "";
		System.out.println("확인2");
		
		System.out.println(pw);
		System.out.println(pass);
		
		if(pw.equals(pass)) {
			System.out.println("성공");
			url = "memberCheckSuccess.jsp";
		}else {
			url = "memberCheckPass.jsp";
			System.out.println("연주");
			req.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
		}
		req.getRequestDispatcher(url).forward(req, resp);
	}
	

}
