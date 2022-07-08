package chapter03;

import org.springframework.beans.factory.annotation.Autowired;

import exception.MemberNotFoundException;
import exception.WrongIdPasswordException;

public class ChangePasswordService {
	@Autowired
	private MemberDao memberDao;

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
