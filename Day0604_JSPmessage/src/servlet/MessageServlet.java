package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Message;
import service.MessageService;

public class MessageServlet extends HttpServlet {
	private MessageService service;

	public MessageServlet() {
		service = MessageService.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}

	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		String contextPath = req.getContextPath();
		String reqUri = req.getRequestURI();

		System.out.println("요청받음 : " + reqUri);

		// if(reqUri.equals(contextPath + "/messageList")) {
		// //모든 메시지 목록을 가져와서 속성에 담아서
		// List<Message> messageList = service.getAllMessages();
		// req.setAttribute("messageList", messageList);
		//
		// //표시할 화면으로 전달
		// req.getRequestDispatcher("messageList.jsp").forward(req, resp);
		//
		// }

		if (reqUri.equals(contextPath + "/messageList")) {
			// 1. 페이지에 표시될 목록 가져오기
			int pageNumber = 1;
			String strPageNumber = req.getParameter("page");

			if (strPageNumber != null) {
				pageNumber = Integer.parseInt(strPageNumber);
			}
			//페이지 네비게이션 출력을 위한 정보를 전달
			Map<String, Object> viewData = service.getMessageList(pageNumber);
			req.setAttribute("viewData", viewData);

			req.getRequestDispatcher("messageList.jsp").forward(req, resp);

		} else if (reqUri.equals(contextPath + "/write")) {
			// 데이터를 파라미터에서 받아와서 서비스로 전달
			String name = req.getParameter("guestName");
			String password = req.getParameter("password");
			String message = req.getParameter("message");

			boolean result = service.writeMessage(name, password, message);

			if (result == true) {
				req.setAttribute("msg", "정상 등록 되었습니다.");
			} else {
				req.setAttribute("msg", "등록 실패하였습니다.");
			}
			req.setAttribute("url", "messageList");
			req.getRequestDispatcher("result.jsp").forward(req, resp);

		} else if (reqUri.equals(contextPath + "/confirmDeletion")) {
			req.getRequestDispatcher("confirmDeletion.jsp").forward(req, resp);
		} else if (reqUri.equals(contextPath + "/pwCheck")) {
			// 해당 id의 게시글의 비밀번호와, 입력받은 비밀번호가 같은지 확인
			String strId = req.getParameter("id");
			String password = req.getParameter("password");

			int id = Integer.parseInt(strId);

			boolean result = service.deleteMessage(id, password);
			String msg = "삭제 실패하였습니다.";
			if (result) {
				msg = "성공적으로 삭제하였습니다.";
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", "messageList");

			req.getRequestDispatcher("result.jsp").forward(req, resp);
		}
	}
}
