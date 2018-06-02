package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "dlduswn";
	private static final String PASSWORD = "90996442";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		//1. 드라이버 로딩,
		//2. 연결 하고, 반환
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
