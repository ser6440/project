package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDao dao = BoardDaoImp.getInstance();
		
		Board board = new Board();
		board.setTitle(req.getParameter("title"));
		board.setId(req.getParameter("id"));
		board.setContent(req.getParameter("content"));
		
		
		System.out.println(board);
		int result = dao.insertBoard(board);
		
		
		

		if(result > 0) {
			req.setAttribute("msg", "등록완료");
		}else {
			req.setAttribute("msg", "등록 중 오류가 발생하였습니다.");
		}
		req.setAttribute("url", "board_list");
		
		req.getRequestDispatcher("boardResult.jsp").forward(req, resp);
		
		
		
	}

}
