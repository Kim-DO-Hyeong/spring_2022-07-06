package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import chapter07.Member;

public class Database {
	
	public Member selectByEmail(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/spring_2022-07-13?user=root&password=1234");
			
			String sql = "SELELCT * FROM member WHERE email =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				String password = rs.getString("password");
				LocalDateTime registerDateTime = rs.getTimestamp("registDateTime").toLocalDateTime();
				
				Member member = new Member(email, password, name, registerDateTime);
				
				return member;

			}
		}catch(ClassNotFoundException e) {
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	
	}
}
