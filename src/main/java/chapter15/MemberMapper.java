package chapter15;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

public class MemberMapper implements RowMapper<Member> {
	
	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		long memberNumber = rs.getLong("memberNumber");
		String email = rs.getString("email");
		String password = rs.getString("password");
		String name = rs.getString("name");
		LocalDateTime regDate = rs.getTimestamp("regDate").toLocalDateTime();
		
		Member member = new Member(email, password, name, regDate);
		member.setId(memberNumber);
		
		return member;
	}
}
