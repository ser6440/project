package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardViewAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//상세보기 요청
		//데이터베이스에서 게시글 하나의 정보를 가져와서 상세보기 페이지로 전달
		String url = "jsp/boardView.jsp";
		BoardDao dao = BoardDaoImp.getInstance();
		String num = req.getParameter("num");
		dao.updateReadCount(num);
		Board board = dao.selectOne(num);
		req.setAttribute("board", board);
		req.getRequestDispatcher(url).forward(req, resp);
		
	}

}
