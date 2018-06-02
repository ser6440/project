package service;

import java.util.List;

import dao.MessageDao;
import model.Message;

public class MessageService {
	MessageDao messageDao;
	
	public MessageService() {
		messageDao = new MessageDao();
	}
	
	public boolean join(Message message) {
		int insertResult = messageDao.insertMessage(message);
		boolean result = false;
		if(insertResult == 1) {
			result = true;
		}
		return result;
	}
	
	public List<Message> getAllMessage(){
		return messageDao.selectAll();
	}
}
