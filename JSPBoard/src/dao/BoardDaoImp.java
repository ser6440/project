package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Board;


public class BoardDaoImp implements BoardDao{

	private static BoardDao instance;
	private BoardDaoImp() {
		
	}
	public static BoardDao getInstance() {
		if(instance == null) {
			instance = new BoardDaoImp();
		}
		return instance;
	}
	
	public int insertBoard(Board board) {
		String sql = "insert" + 
				" into board " + 
				" values(board_seq.nextval,?,?,?,?,?,0,sysdate)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getPass());
			pstmt.setString(4, board.getEmail());
			pstmt.setString(5, board.getContent());
			
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
	
	public int updateBoard(Board board) {
		String sql = "update board "
				+ "  set title = ?, "
				+ "	name = ?, "
				+ "	pass = ?, "
				+ "	email = ?, "
				+ "	content = ? "
				+ "	where num = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getPass());
			pstmt.setString(4, board.getEmail());
			pstmt.setString(5, board.getContent());
			pstmt.setInt(6, board.getNum());
			
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
	public int deleteBoard(String num) {
		String sql = "delete " 
	               + " from board" 
				   + " where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
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
	public Board selectOne(String num) {
		String sql ="select * from board where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board result = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = new Board();
				
				result.setNum(rs.getInt("num"));
				result.setTitle(rs.getString("title"));
				result.setName(rs.getString("name"));
				result.setPass(rs.getString("pass"));
				result.setEmail(rs.getString("email"));
				result.setContent(rs.getString("content"));
				result.setReadCount(rs.getInt("readCount"));
				result.setWriteDate(rs.getDate("writeDate"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
				if (rs !=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public List<Board> selectAll() {
		String sql = "select *  from board";
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<Board> result = new ArrayList<Board>();
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Board board = new Board();
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setName(rs.getString("name"));
				board.setPass(rs.getString("pass"));
				board.setEmail(rs.getString("email"));
				board.setContent(rs.getString("content"));
				board.setReadCount(rs.getInt("readCount"));
				board.setWriteDate(rs.getDate("writeDate"));
				result.add(board);
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
	public int updateReadCount(String num) {
		String sql = "update board " 
				+ "	     set readCount = readCount+1"
				+ "    where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
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
}
