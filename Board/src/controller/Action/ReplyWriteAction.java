package controller.Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReplyDao;
import dao.ReplyDaoImp;
import model.Reply;

public class ReplyWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReplyDao rd = ReplyDaoImp.getInstance();
		
		Reply reply = new Reply();
		reply.setbNum(Integer.parseInt(req.getParameter("num")));
		reply.setId(req.getParameter("id"));
		reply.setContent(req.getParameter("content"));
		
		System.out.println(reply);
		
		int result = rd.insertReply(reply);
		
		if(result > 0 ) {
			req.setAttribute("msg", "등록완료");
		}else {
			req.setAttribute("msg", "등록 실패");
		}
		
		
		req.setAttribute("url", "board_view&num="+req.getParameter("num"));
		req.getRequestDispatcher("boardResult.jsp").forward(req, resp);
		
		
//		List<Reply> replyList  = rd.selectAll();
//		
//		req.setAttribute("replyList", replyList);
//		req.getRequestDispatcher("board/boardView.jsp").forward(req, resp);
		
	}

}
