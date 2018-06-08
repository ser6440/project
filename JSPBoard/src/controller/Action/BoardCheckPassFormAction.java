package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardCheckPassFormAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//비밀번호 입력할수있는 화면 띄워주기
		String url = "jsp/boardCheckPass.jsp";
		req.getRequestDispatcher(url).forward(req, resp);
		
		
	}

}
