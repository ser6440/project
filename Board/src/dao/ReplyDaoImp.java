package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reply;

public class ReplyDaoImp implements ReplyDao{
	private static ReplyDao instance;
	
	private ReplyDaoImp() {
		
	}
	
	public static ReplyDao getInstance() {
		if(instance == null) {
			instance = new ReplyDaoImp();
		}
		return instance;
	}
	
	@Override
	public int insertReply(Reply reply) {
		String sql = "insert " +
	                 "into reply " +
				     "values(reply_seq.nextval,?,?,?,sysdate)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reply.getbNum());
			pstmt.setString(2, reply.getContent());
			pstmt.setString(3, reply.getId());
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
					if(pstmt != null)pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return result;
	}

	@Override
	public int updateReply(Reply reply) {
		String sql = "update reply " +
	                 "set content =? " +
				     "where rNum =? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reply.getContent());
			pstmt.setInt(2, reply.getrNum());
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
				if(pstmt != null)pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		return result;
	}

	@Override
	public int deleteReply(String rNum) {
		String sql = "delete "
				+ " from reply " 
				+ " where rNum =? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		System.out.println("들어오니??"+result);
		
		try {
			conn = ConnectionProvider.getConnection();
		
			
			pstmt = conn.prepareStatement(sql);
			
			System.out.println(sql);
			
			pstmt.setString(1, rNum);
			
			System.out.println("들어왕?");
			
			result = pstmt.executeUpdate();
			
			System.out.println(result);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if (pstmt != null)pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Reply selectOne(String rNum) {
		String sql = "select * from reply whrer rNum=? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reply result = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = new Reply();
				
				result.setbNum(rs.getInt("bNum"));
				result.setrNum(rs.getInt("rNum"));
				result.setContent(rs.getString("content"));
				result.setId(rs.getString("id"));
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
	public List<Reply> selectAll() {
		String sql = "select * from reply";
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<Reply> result = new ArrayList<Reply>();
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reply reply = new Reply();
				reply.setbNum(rs.getInt("bNum"));
				reply.setrNum(rs.getInt("rNum"));
				reply.setId(rs.getString("id"));
				reply.setContent(rs.getString("content"));
				reply.setWriteDate(rs.getDate("writeDate"));
				result.add(reply);
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

}
