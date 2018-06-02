package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Loan;

//loanService요청처리하는 Servlet작성
//요청 처리하고 나서 loanResult.jsp로 데이터 전달

@WebServlet("/loanService")
public class LoanServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 데이터 처리하기
		// 파라미터는 모두 문자열 또는 문자열[]
		String amountStr = req.getParameter("amount");
		String rateStr = req.getParameter("rate");
		String periodStr = req.getParameter("period");
		String typeStr = req.getParameter("type");
		
		List<Loan> loanList = new ArrayList<Loan>();
		
		//파라미터에 있는 숫자를 적절한 데이터 타입으로 변환
		int amount = Integer.parseInt(amountStr);
		double rate = Double.parseDouble(rateStr);
		int period = Integer.parseInt(periodStr);
		int type = Integer.parseInt(typeStr);
		
		double mRate = rate/100/12;
		
			
int repayTotal,repayOrigin,interest,repaySum,repayRemain;
		
		repayRemain = amount;
		repaySum = 0;
		int repayMonth;
	
		if(type == 1){
			//원금 균등상환
			repayMonth = amount/period;
		}else{
			//원리금 균등상환
			//원리금 균등상환 계산식: (원금*월이율*Math.pow((1+월이율),period)/(Math.pow((1+월이율),period)-1)
			
			repayMonth = (int)((amount*mRate*Math.pow(1+mRate, period))/(Math.pow(1+mRate, period)-1));
		}
		
		//원금 균등상환 : repayMonth + 이자
		//원리금 균등상환 : repayMonth
		
		for(int i=1;i<=period;i++){
			//이자계산: 잔금*이율
			interest = (int)(repayRemain*mRate);
			
			if(type == 1){
				//원금 균등상환
				repayTotal = repayMonth + interest;	//이번달 낼 금액의 총합
				repayOrigin = repayMonth;	//이번달 낸 원금
			}else{
				//원리금 균등상환
				repayTotal = repayMonth;	
				repayOrigin = repayMonth - interest;	//이번 달 낸 원금
			}
			repayRemain = repayRemain - repayOrigin;
			
			repaySum = repaySum + repayTotal;
			
			Loan loan = new Loan();
			loan.setRepayTotal(repayTotal);
			loan.setRepayOrigin(repayOrigin);
			loan.setRepayRemain(repayRemain);
			loan.setRepaySum(repaySum);
			loan.setInterest(interest);
			//한줄에 들어갈 데이터 모두 계산, 데이터를 바로 사용하는 것이 아니라
			//전달 해야되기 때문에 저장. Loan클래스의 객체 만들기
			loanList.add(loan);
		}	//for end
		//전달할 데이터 모두 만들어 냈으니 전달하기,전달하기 위해서 속성에 담기
		req.setAttribute("loanList", loanList);
		
		req.getRequestDispatcher("04loanResult.jsp").forward(req, resp);
		
	}
}
