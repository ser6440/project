package dao;

import java.util.List;

import model.BoardMember;

public interface BoardMemberDao {
	public int insertBoardMember(BoardMember boardmember);
	public int updateBoardMember(BoardMember boardmember);
	public int deleteBoardMember(String id);
	public BoardMember selectOne(String id);
	public List<BoardMember> selectAll();
}
