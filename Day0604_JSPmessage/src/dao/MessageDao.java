package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Message;

public class MessageDao {
	
	private static MessageDao instance;
	
	//selectAll() : List<Message>
	//selectOne(int id) : Message
	//insertMessage(Message) : int
	//deleteMessage(int id) : int
	
	
	
	private MessageDao() {
		//private이기 때문에 외부에서는 new키워드를 이용해서 생성자를 호출할 수 없다.
	}
	public static MessageDao getInstance() {
		//만들어진 객체가 없다면, 객체를 만들어서 반환
		if(instance == null) {
			instance = new MessageDao();
		}
		//있다면, 객체를 만들지 않고 그냥 반환
		return instance;
	}
	
	public int insertMessage(Message message) {
		String sql ="insert into message "
				+ "values(message_seq.nextval,?,?,?)";
		
		Connection connection = null;
		PreparedStatement pstmt =null;
		int result = 0;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, message.getPassword());
			pstmt.setString(2, message.getName());
			pstmt.setString(3, message.getMessage());
			result = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(connection != null)connection.close();
					if(pstmt != null) pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		return result;
	}
	public int deleteMessage(int id) {
		String sql = "delet from message where id = ?";
		
		Connection connection = null;
		PreparedStatement pstmt =null;
		int result = 0;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1,id);
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection != null)connection.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		return result;
	}
	public Message selectOne(int id) {
		String sql ="select * from message where id = ?";
		
		Connection connection = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		Message result = null;
		
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new Message();
				
				result.setId(rs.getInt("id"));
				result.setPassword(rs.getString("name"));
				result.setName(rs.getString("password"));
				result.setMessage(rs.getString("message"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection != null)connection.close();
				if(pstmt != null) pstmt.close();
				if (rs !=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

		return result;
	}
	public List<Message> selectAll(){
		String sql = "select * from message";
		Connection connection = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<Message> result = new ArrayList<Message>();
		
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Message message = new Message();
				message.setId(rs.getInt("id"));
				message.setName(rs.getString("name"));
				message.setPassword(rs.getString("password"));
				message.setMessage(rs.getString("message"));
				result.add(message);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection != null)connection.close();
				if(pstmt != null) pstmt.close();
				if (rs !=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		return result;
	}
	
	
	
	
	public List<Message> selectList(int firstRow, int endRow){
		String sql = "select  * " 
				+ "  from (select rownum as rnum," 
				+ "       m.id," 
				+ "       m.password,"
				+ "       m.name," 
				+ "       m.message" 
				+ "  from (select id,password,name,message"
				+ "          from message" 
				+ "        order by id desc) m ) " 
				+ " where rnum between ? and ?";

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		List<Message> result = new ArrayList<Message>();
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Message message = new Message();
				message.setId(rs.getInt("id"));
				message.setName(rs.getString("name"));
				message.setPassword(rs.getString("password"));
				message.setMessage(rs.getString("message"));
				
				result.add(message);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			try {
				if (connection != null)
					connection.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	//가져와서 sql 바꾸기 
	public int selectCount() {
		//총메세지의 개수를 구하는 메서드
		String sql ="select count(*) from message";
		
		Connection connection = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection != null)connection.close();
				if(pstmt != null) pstmt.close();
				if (rs !=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		return result;
	}
}
