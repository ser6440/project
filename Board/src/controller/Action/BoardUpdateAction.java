package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDao dao = BoardDaoImp.getInstance();

		
		Board board = new Board();
		board.setNum(Integer.parseInt(req.getParameter("num")));
		board.setTitle(req.getParameter("title"));
		board.setContent(req.getParameter("content"));
		board.setId(req.getParameter("id"));
		
		int result = dao.updateBoard(board);
		String url = "boardResult.jsp";
		
		if(result>0) {
			req.setAttribute("msg", "변경완료");
		}else {
			req.setAttribute("msg", "수정 실패");
		}
		req.setAttribute("url","board_list");
		
		req.getRequestDispatcher(url).forward(req, resp);
		
	}

}
