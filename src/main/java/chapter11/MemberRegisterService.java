package chapter11;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import exception.DuplicateMemberException;

public class MemberRegisterService {
	
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public long regist(RegisterRequest req) throws DuplicateMemberException{
		// 이메일로 회원 데이터 조회
		Member member = memberDao.selectByEmail(req.getEmail());

		if (member != null) {
			throw new DuplicateMemberException();
		}

		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());

		// DAO 를 사용해서 회원 가입
		memberDao.insert(newMember);
		
		return newMember.getId();
	}
}
