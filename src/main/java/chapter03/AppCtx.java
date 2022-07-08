package chapter03;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

	@Bean
	@Qualifier("printer1")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("printer2")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
	@Bean
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService();
	}

	@Bean
	public ChangePasswordService changePasswordService() {
		ChangePasswordService cps = new ChangePasswordService();
		// @Autowired 로 자동주입을 해서 세터가 필요없음 
		return cps;
	}

	@Bean
	public MemberListPrinter memberListPrinter() {
		MemberListPrinter mlp = new MemberListPrinter();

		return mlp;
	}

	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter mip = new MemberInfoPrinter();
		// 자동 의존 주입을 적용했기 때문에 수동의존 주입이 무시가 되어버림 
		mip.setMemberPrinter(new MemberPrinter()); // 자동주입 한줄 모르고 수동 주입을 또 했을때
		return mip;
	}

	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter vp = new VersionPrinter();

		vp.setMajor(1);
		vp.setMinor(4);

		return vp;
	}
	
//	@Bean
//	public DateTimeFormatter dateTimeFormatter() {
//		return DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분 ss초");
//	}

}
