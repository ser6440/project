package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.MessageDao;
import model.Message;

public class MessageService {
	private static MessageService instance;
	private MessageDao messageDao;
	
	//한 페이지에 표시될 메시지의 개수
	private static final int NUM_OF_MESSAGE_PER_PAGE = 10;
	//한번에 표시될 네비게이션의 개수
	private static final int NUM_OF_NAVI_PAGE = 10;
	
	
	private MessageService() {
		messageDao = MessageDao.getInstance();
	}
	
	public static MessageService getInstance() {
		if(instance == null) {
			instance = new MessageService();
		}
		return instance;
	}
	//모든 메시지 목록 가져오기
	public List<Message> getAllMessages(){
		return messageDao.selectAll();
	}
	
	public boolean writeMessage(String name,String pw,String message) {
		Message m = new Message();
		m.setName(name);
		m.setPassword(pw);
		m.setMessage(message);
		int result = messageDao.insertMessage(m);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteMessage(int id, String password) {
		Message message = messageDao.selectOne(id); 
		
		if(message != null && message.getPassword().equals(password)) {
			messageDao.deleteMessage(id);
			return true;
		}
		return false;
	}
	public Map<String, Object> getMessageList(int pageNumber) {
		//현재 페이지에 표시될 메시지 목록 가져오기
		//화면에 표시될 네비게이션의 정보를 계산 및 생성
		//리스트 + 나머지 데이터들도 같이 담아서 전달 >> Map으로 전달(messageList,startPage,endPage,totalPage)
		
		//화면을 표시하기 위한 데이터들의 모음 viewData
		Map<String, Object> viewData = new HashMap<String,Object>();
		
		//1. 현재 페이지에 표시될 메세지 목록 가져오기 
		/*      firstRow    endRow
		 * 1페이지 :  1          10
		 * 2페이지 :  11         20
		 * 3페이지 :  21         30
		 * 4페이지 :  31         40
		 */
		int firstRow = 0;
		int endRow = 0;
		int totalCount = 0;	//총 메시지의 개수, 총 페이지 수를 구하기 위해 필요
		
		totalCount = messageDao.selectCount();	//총 메세지 개수	
		firstRow = (pageNumber-1)*NUM_OF_MESSAGE_PER_PAGE+1;
		endRow = pageNumber*NUM_OF_MESSAGE_PER_PAGE;
		
		//dao 만들기 : List<Message> selectList(int,int)
		
		List<Message> messageList = messageDao.selectList(firstRow, endRow);
		
		viewData.put("currentPage", pageNumber);
		viewData.put("messageList", messageList);
		viewData.put("pageTotalCount", calPageTotalCount(totalCount));
		viewData.put("startPage", getStartPage(pageNumber));
		viewData.put("endPage", getEndPage(pageNumber));
		//필요한 데이터 : 총페이지의 개수, 총 메시지의 개수
		//시작 페이지, 종료 페이지
		
		
		return viewData;
	}
	
	private int calPageTotalCount(int totalCount) {
		//총 페이지를 계산하는 메서드
		//총 페이지의 개수 반환 : 총 메시지 개수, 페이지당 메시지 수가 있으면 계산 가능
		
		/*
		 * 메시지 수 : 1~10	페이지 수 : 1
		 * 메시지 수 : 11~20	페이지 수 : 2
		 * 100	10
		 * 200	20
		 * 333	34
		 * */
		int pageTotalCount = 0;
		if(totalCount != 0) {
			pageTotalCount = (int)Math.ceil(
					((double)totalCount / NUM_OF_MESSAGE_PER_PAGE));
		}
		return pageTotalCount;
	}
	
	public int getStartPage(int pageNum) {
		//6 >> 1
		//16 >> 11
		//30 >> 21
		//현재 페이지 >> 시작페이지
		
		int startPage = ((pageNum-1)/NUM_OF_NAVI_PAGE)*NUM_OF_NAVI_PAGE + 1;
		return startPage;
	}
	
	public int getEndPage(int pageNum) {
		//6  >> 10
		//10 >> 10
		int endPage = (((pageNum - 1)/NUM_OF_NAVI_PAGE)+1)*NUM_OF_NAVI_PAGE;
		return endPage;
	}
}
