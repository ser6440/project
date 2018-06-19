package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardMemberDao;
import dao.BoardMemberDaoImp;
import model.BoardMember;

public class MemberCheckIdAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String id = req.getParameter("id");
	      BoardMemberDao dao  = BoardMemberDaoImp.getInstance();
	      
	      BoardMember bm = dao.selectOne(id);
	      
	   
//	      System.out.println(member);
	      
	      String result = "";
	      if (bm != null) {
	         // 아이디 사용불가
	         
	         result = "{\"result\" : false}";
	      
	         
	      } else {
	         // 아이디 사용 사능
	         result = "{\"result\" : true}";
	      
	         
	      }
	      
	      
	      resp.getWriter().println(result);
	   

	   }
	   
		
	}

