package chapter07;

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
	
	// 트랜잭션을 적용시키는 애노테이션
	// 이 애노테이션이 붙은 메서드가 정상적으로 끝났을 때만 실행해야할 쿼리를 진짜로 실행시킴 
	// 이 애노테이션이 붙은 매서드가 예외가 발생하여 비정상적으로 끝났을 때는 실행해야할 쿼리를 취소시킴( 롤백 ) 
	@Transactional
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
