package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReplyDao;
import dao.ReplyDaoImp;

public class ReplyDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReplyDao rd = ReplyDaoImp.getInstance();
		
		System.out.println("qkqh");
		String rNum = req.getParameter("rNum");
		System.out.println(rNum);
		int result = rd.deleteReply(rNum);
		System.out.println(result);
		String url = "boardResult.jsp";
		
		if(result > 0 ) {
			req.setAttribute("msg", "삭제완료");
		}else {
			req.setAttribute("msg", "삭제실패");
		}
		req.setAttribute("url", "board_view&num="+req.getParameter("num"));
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
