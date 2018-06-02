package model;

public class Loan {
	//회차별 대출 상환 정보를 저장할 수 있는 클래스
	//각 회차별 필요한 데이터
	//상환액 : repayTotal :월 상환원금+월 이자
	//상환원금: repayOrigin :월 상환원금
	//이자: interest : 이자금액
	//상환총액 : repaySum : 상환누적금액 
	//대출잔액 : repayRemain: 원금-상환원금 총액
	
	int repayTotal;
	int repayOrigin;
	int interest;
	int repaySum;
	int repayRemain;
	
	public int getRepayTotal() {
		return repayTotal;
	}
	public void setRepayTotal(int repayTotal) {
		this.repayTotal = repayTotal;
	}
	public int getRepayOrigin() {
		return repayOrigin;
	}
	public void setRepayOrigin(int repayOrigin) {
		this.repayOrigin = repayOrigin;
	}
	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) {
		this.interest = interest;
	}
	public int getRepaySum() {
		return repaySum;
	}
	public void setRepaySum(int repaySum) {
		this.repaySum = repaySum;
	}
	public int getRepayRemain() {
		return repayRemain;
	}
	public void setRepayRemain(int repayRemain) {
		this.repayRemain = repayRemain;
	}
	@Override
	public String toString() {
		return "Loan [repayTotal=" + repayTotal + ", repayOrigin=" + repayOrigin + ", interest=" + interest
				+ ", repaySum=" + repaySum + ", repayRemain=" + repayRemain + "]";
	}

}
