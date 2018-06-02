package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	//'login'이라는 요청을 받아서 처리
	//1. 요청의 파라미터에서 userid와 userpw를 가져온다.
	//2. 임의의 id와 파라미터에서  받아온 값과 비교
	//3-1. id,pw가  같으면 
	//		3-1-1로그인 처리하고
	//		3-1-2메인 화면을 보여달라는 요청
	//3-2. id,pw가 다르면 로그인창으로 다시 보내기
	
	String myId = "dlduswn";
	String myPw = "1234";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req,resp);
	}
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get,post방식 둘다처리
		
		//1. 요청의 파라미터에서 useid와 usepw를 가져온다.
		String id = req.getParameter("userid");
		String pw = req.getParameter("userpw");
		HttpSession session = req.getSession();
		
		
		String url ="04loginForm.jsp";
		if(id != null && id.equals(myId)) {
			//아이디 존재/아이디 일치
			//2. 임의의 id와 pw를 파라미터에서 받아온 값과 비교
			if(pw != null && pw.equals(myPw)) {
				//아이디 비밀번호 일치, 로그인 성공
				//3-1 id,pw가 같으면
				//	3-1-1 로그인 처리하고 : session에 userid이름으로 속성 지정하기
				session.setAttribute("userid",id);
				//3-1-2 메인화면을 보여달라는 요청
//				resp.sendRedirect("04main.jsp");
				url = "main";
			}else {
				//3-2 id,pw가 다르면 로그인창으로 다시 보내기
				//비밀번호 오류,로그인 실패
//				resp.sendRedirect("04loginForm.jsp");
			}
		}else {
			//3-2 id,pw가 다르면 로그인 창으로 다시 보내기
			//아이디 오류, 로그인 실패
//			resp.sendRedirect("04loginForm.jsp");
		}
		resp.sendRedirect(url);	
	}
	
}
