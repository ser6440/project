package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BoardMember;

public class BoardMemberDaoImp implements BoardMemberDao{
	private static BoardMemberDao instance;
	private BoardMemberDaoImp() {
		
	}
	public static BoardMemberDao getInstance() {
		if(instance == null) {
			instance = new BoardMemberDaoImp();
		}
		return instance;
	}
	
	@Override
	public int insertBoardMember(BoardMember boardmember) {
		String sql = "insert" +
	                 " into boardmember" +
				     " values(board_seq.nextval,?,?,?,?,sysdate)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, boardmember.getNum());
			pstmt.setString(1, boardmember.getId());
			pstmt.setString(2, boardmember.getPw());
			pstmt.setString(3, boardmember.getName());
			pstmt.setString(4, boardmember.getEmail());
			result = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	return result;
		
	}

	@Override
	public int updateBoardMember(BoardMember boardmember) {
		String sql = "update boardmember"
				+ " set pw = ?, "
				+ " name = ?, "
				+ " email = ? "
				+ " where id =? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println("수정창에서 넘버"+boardmember.getNum());
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardmember.getPw());
			pstmt.setString(2, boardmember.getName());
			pstmt.setString(3, boardmember.getEmail());
			pstmt.setString(4, boardmember.getId());
			result = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int deleteBoardMember(String id) {
		String sql = "delete"
				+ " from boardmember "
				+ " where id = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null) conn.close();
				if(pstmt !=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public BoardMember selectOne(String id) {
		String sql = "select * from boardmember where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardMember result = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = new BoardMember();
				
				result.setNum(rs.getInt("num"));
				result.setId(rs.getString("id"));
				result.setPw(rs.getString("pw"));
				result.setName(rs.getString("name"));
				result.setEmail(rs.getString("email"));
				result.setRegDate(rs.getDate("reg_date"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null) conn.close();
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public List<BoardMember> selectAll() {
		String sql = "select * from boardmember";
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<BoardMember> result = new ArrayList<BoardMember>();
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardMember boardmember = new BoardMember();
				boardmember.setNum(rs.getInt("num"));
				boardmember.setId(rs.getString("id"));
				boardmember.setPw(rs.getString("pw"));
				boardmember.setName(rs.getString("name"));
				boardmember.setRegDate(rs.getDate("reg_date"));
				result.add(boardmember);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null) conn.close();
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
		
		}
	public boolean loginCheck(String id,String pw) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from boardmember where id=? and pw=? ";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}


}
