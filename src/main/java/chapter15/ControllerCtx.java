package chapter15;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ControllerCtx {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
		ds.setUrl("jdbc:mariadb://localhost:3306/spring_2022-07-13");
		ds.setUsername("root");
		ds.setPassword("1234");
		return ds;
	}
	
	
	@Bean
	public MemberDao memberDao() {
		MemberDao memberDao = new MemberDao();
		memberDao.setJdbcTemplate(dataSource());
		return memberDao;
	}
	
	@Bean
	public MemberRegisterService memberRegisterService() {
		MemberRegisterService rmc = new MemberRegisterService();
		rmc.setMemberDao(memberDao());
		
		return rmc;
	}
	
	
	@Bean
	public RestMemberController restMemberController() {
		RestMemberController rmc = new RestMemberController();
		rmc.setMemberDao(memberDao());
		rmc.setMemberRegisterService(memberRegisterService());
		
		return rmc;
	}
}
