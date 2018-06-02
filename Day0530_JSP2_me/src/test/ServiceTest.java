package test;





import org.junit.Test;

import dao.MemberDao;
import model.Member;
import service.MemberService;


public class ServiceTest {
	//서비스 클래스가 제대로 동작하는지 확인하는클래스
	//테스트를 수행하는 메서드를 가지고 있는 클래스
	
	MemberService service;
	MemberDao dao;
	
	@Test
	public void testService() {
		service = new MemberService();
		boolean result = service.login("hong123", "123");
		System.out.println(result);
	}
	
	@Test
	public void daoTest() {
		MemberDao dao = new MemberDao();
		//insertTest
		Member member = new Member();
		member.setId("id1");
		member.setName("홍길순");
		member.setPw("1111");
		
		int result = dao.updateMember(member);
		System.out.println("insert 결과 : " + result); 
	}
}
