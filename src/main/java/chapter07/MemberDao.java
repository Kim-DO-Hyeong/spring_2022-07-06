package chapter07;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Member selectByEmail(String email) {
		String sql = "SELECT * FROM member WHERE email =?";
		
//		List<Member> result = jdbcTemplate.query(sql, new MemberMapper(), email);

//		return result.isEmpty() ? null : result.get(0);
		
		// count() 메서드와 마찬가지로 selectByEmail() 메서드 역시 SELECT 결과가 한 행이므로 
		// JdbcTemplate의 query() 메서드 대신 queryForObject() 메서드 대신에 사용하면 됨
		// count() 메서드 에서는 queryForObject() 메서드가 반환하는 값이 int 또는 Integer 여야 하므로 
		// 자바가 제공하는 Integer 클래스를 반환하도록 할 수 있음 
		
		// selectByEmail() 메서드는 queryForObject() 메서드가 반환하는 값이 Member여야 하므로 
		// Member는 자바가 제공하는게 아님 / 그래서 MemberMapper 의 mapRow 사용해서 Member를 반환하도록 한 것 
		Member member = jdbcTemplate.queryForObject(sql, new MemberMapper(), email);
		
		// email 을 잘 못 입력해서 select 의 결과가 없을 수 옫 있음 
		// SELECT 의 결과가 없는 상황에서는 queryForObject() 메서드가 예외를 발생 시킴
		// queryForObject() 메서드는 실행 결과가 반드시 한 줄 일 때만 사용하는게 좋음 
		return member;
	}
	
	public Collection<Member> selectAll(){ 
		String sql = "SELECT * FROM member";
		
		List<Member> result = jdbcTemplate.query(sql, new MemberMapper());
		return result.isEmpty() ? null : result;
	}
	
	public void insert(Member member) {
	}
	
	public void update (Member member) {
	}
	
	// 가입된 회원의 수를 반환하는 메서드 
	public int count() {
		String sql = "SELECT COUNT(*) AS count FROM member";
		
//		List<Integer> result = jdbcTemplate.query(sql, new RowMapper<Integer>() {
//
//			@Override
//			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
//				int count = rs.getInt("count"); 
//				
//				return count;
//			}
//		});
		
		// SELECT 결과가 한 행 일 때는 query() 메서드 대신 queryForObject() 메서드를 사용하면 좋음 코드 간략 
		
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return count;
	}
	
	
}
