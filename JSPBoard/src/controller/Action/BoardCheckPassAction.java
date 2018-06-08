package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardCheckPassAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터에서 게시글 번호와 비밀번호 가져와서
		//해당 게시글의 비밀번호와 입력받은 비밀번호가 같으면
		//수정화면으로 이동 아니면 비밀번호 입력화면으로 이동
		
		String num = req.getParameter("num");
		String pass = req.getParameter("pass");
		
		BoardDao dao = BoardDaoImp.getInstance();
		Board board = dao.selectOne(num);
		
		String url = "";
		
		if(board.getPass().equals(pass)) {
			//비밀번호 같음
			//수정화면으로 이동
			url = "jsp/checkSuccess.jsp";
			//바로 화면을 이동하면 팝업화면에서 계속 진행...>>
			//해결
			
			
		}else {
			//비밀번호 틀림
			//비밀번호 입력창으로 이동
			url = "jsp/boardCheckPass.jsp";
			req.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
		}
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
