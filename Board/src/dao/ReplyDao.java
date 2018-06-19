package dao;

import java.util.List;

import model.Reply;

public interface ReplyDao{
	public int insertReply(Reply reply);
	public int updateReply(Reply reply);
	public int deleteReply(String rNum);
	public Reply selectOne(String rNum);
	public List<Reply> selectAll();
}
