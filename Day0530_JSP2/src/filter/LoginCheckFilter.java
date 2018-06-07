package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("필터가 요청을 받았습니다.");
		//이 필터는 login, loginForm, join, joinForm을 제외한
		//나머지 모든 요청에 대해서 한번 확인하고, 로그인 상태가 아니면 로그인 화면으로 보내야 한다.
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)req;
		HttpServletResponse httpServletResponse = (HttpServletResponse)resp;
		HttpSession httpSession = httpServletRequest.getSession();
		
		if(httpSession.getAttribute("userid")!=null) {
			chain.doFilter(req, resp);
			
		}else {
			//로그인화면으로 보내기
			httpServletResponse.sendRedirect("loginForm");
//			RequestDispatcher dispatcher = req.getRequestDispatcher("loginForm.jsp");
//			dispatcher.forward(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
