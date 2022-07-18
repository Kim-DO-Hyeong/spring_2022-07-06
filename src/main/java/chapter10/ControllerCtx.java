package chapter10;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerCtx {

	@Bean
	public RegisterController registerController() {
		RegisterController registerController = new RegisterController();
		registerController.setMemberRegisterService(memberRegisterService());
		
		return registerController;
	}
	
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
	public ChangePasswordService changePasswordService() {
		ChangePasswordService svc = new ChangePasswordService();
		svc.setMemberDao(memberDao());
		
		return svc;
	}

	@Bean
	public MemberRegisterService memberRegisterService() {
		MemberRegisterService svc = new MemberRegisterService();
		svc.setMemberDao(memberDao());
		
		return svc;
	}
	
}
