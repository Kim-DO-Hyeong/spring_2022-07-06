package chapter02;

import java.time.LocalDateTime;

import exception.DuplicateMemberException;

public class MemberRegisterService {
	// 의존 주입
	// DI 방식 의존 주입 - 생성자 방식
	private MemberDao memberDao;
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}// 의존주입 end
	
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
