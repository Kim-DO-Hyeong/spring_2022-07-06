package chapter02;

import exception.MemberNotFoundException;
import exception.WrongIdPasswordException;

public class ChangePasswordService {
	private MemberDao memberDao;

	// 생성자 방식의 DI 로 의존 주입을 하세요.
//	public ChangePasswordService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
	
	// setter 방식으로 DI (의존 주입 ) 
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void changePassword(String email, String oldPw, String newPw)
			throws MemberNotFoundException, WrongIdPasswordException {
		Member member = memberDao.selectByEmail(email);

		if (member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPw, newPw);

		memberDao.update(member);
	}
}
