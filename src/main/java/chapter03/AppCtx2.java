package chapter03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx2 {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter memberPrinter;

	@Bean
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService(memberDao);
	}

	@Bean
	public ChangePasswordService changePasswordService() {
		ChangePasswordService cps = new ChangePasswordService();
		cps.setMemberDao(memberDao);

		return cps;
	}

	@Bean
	public MemberListPrinter memberListPrinter() {
		MemberListPrinter mlp = new MemberListPrinter(memberDao, memberPrinter);

		return mlp;
	}

	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter mip = new MemberInfoPrinter();
		mip.setMemberDao(memberDao);
		mip.setMemberPrinter(memberPrinter);

		return mip;
	}

	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter vp = new VersionPrinter();

		vp.setMajor(1);
		vp.setMinor(4);

		return vp;
	}
}
