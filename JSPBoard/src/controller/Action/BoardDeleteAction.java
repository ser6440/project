package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;

public class BoardDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDao dao = BoardDaoImp.getInstance();
		String num = req.getParameter("num");
		int result = dao.deleteBoard(num);
		String url ="jsp/result.jsp";
		
		if(result > 0) {
			req.setAttribute("msg", "삭제 완료");
		}else {
			req.setAttribute("msg", "삭제 실패");
		}
		req.setAttribute("url", "board_list");
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
