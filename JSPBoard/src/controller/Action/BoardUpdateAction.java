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
		//파라미터에서 데이터 받아와서 update;
		//결과 출력하고, list로 화면전환
		
		BoardDao dao = BoardDaoImp.getInstance();

		
		Board board = new Board();
		board.setNum(Integer.parseInt(req.getParameter("num")));
		board.setTitle(req.getParameter("title"));
		board.setName(req.getParameter("name"));
		board.setPass(req.getParameter("pass"));
		board.setEmail(req.getParameter("email"));
		board.setContent(req.getParameter("content"));
		
		int result = dao.updateBoard(board);
		String url = "jsp/result.jsp";
		
		if(result>0) {
			req.setAttribute("msg", "변경완료");
		}else {
			req.setAttribute("msg", "수정 실패");
		}
		req.setAttribute("url","board_list");
		
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
