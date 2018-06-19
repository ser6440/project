package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "board/boardModify.jsp";
		//수정은 기본 정보를 포함하는 화면을 출력해야 함
		BoardDao dao = BoardDaoImp.getInstance();
		
		String num = req.getParameter("num");
		Board board = dao.selectOne(num);
		req.setAttribute("board2", board);
		
		
		req.getRequestDispatcher(url).forward(req, resp);
		
	}

}
