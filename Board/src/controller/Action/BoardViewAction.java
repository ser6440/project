package controller.Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import dao.ReplyDao;
import dao.ReplyDaoImp;
import model.Board;
import model.Reply;

public class BoardViewAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "board/boardView.jsp";
		BoardDao dao = BoardDaoImp.getInstance();
		String num = req.getParameter("num");
		dao.updateReadCount(num);
		Board board = dao.selectOne(num);
		
		ReplyDao rd = ReplyDaoImp.getInstance();
		List<Reply> replyList  = rd.selectAll();
		
		req.setAttribute("replyList", replyList);
		
		req.setAttribute("board2", board);
		req.getRequestDispatcher(url).forward(req, resp);
		
	}

}
