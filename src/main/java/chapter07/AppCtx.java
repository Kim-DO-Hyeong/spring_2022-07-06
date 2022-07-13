package chapter07;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
		ds.setUrl("jdbc:maridb://localhost:3306/spring_2022-07-13");
		ds.setUsername("root");
		ds.setPassword("1234");
		
//		ds.setInitialSize(100); // 커넥션 풀이 몇개 지정할 지 정해줌 (기본값 10 )
//		ds.setMaxActive(0); // 기본값은 100 / 커넥션 풀 안에 있는 활성화 될 수 있는 수 
		return ds;
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService MemberRegisterService() {
		MemberRegisterService service = new MemberRegisterService();
		service.setMemberDao(memberDao());
		
		return service;
	}
	
}
