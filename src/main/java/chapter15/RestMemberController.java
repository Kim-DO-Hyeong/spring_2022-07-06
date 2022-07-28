package chapter15;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import exception.DuplicateMemberException;
import exception.MemberNotFoundException;

@RestController
public class RestMemberController {
	
	private MemberDao memberDao;
	private MemberRegisterService memberRegisterService;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	// from ~ to 사이에 가입한 회원 정보를 전달하는 컨트롤러
	@GetMapping("/json/member/list")
	public List<Member> list(MemberListCommand memberListCommand, HttpServletResponse response) {
		
		if(memberListCommand.getFrom() == null || memberListCommand.getTo() == null) {
			// 400 상태코드를 전달 
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
		// DAO 를 사용해서 from~ to 사이에 가입한 회원의 정보를 불러옴 
		List<Member> results = memberDao.selectByRegDate(memberListCommand.getFrom(), memberListCommand.getTo());
		
		if(results.isEmpty()) {
			// from~to 사이에 가입한 회원이 없다면 
			// 204 상태코드를 리턴
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			return null;
		}else {
			// 불러온 회원의 정보를 반환
			return results;
		}
		
		
	}
	
	
	// memberNumber에 맞는 회원 정보를 전달하는 컨트롤러
	@GetMapping("/json/member/detail/{memberNumber}")
	public Member detail(@PathVariable("memberNumber") long memberNumber, HttpServletResponse response) {
		Member member = memberDao.selectByMemberNumber(memberNumber);
		
		if(member == null) {
			// 404 상태코드 설정
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
		return member;
	}
	
	@PostMapping("/json/member/join")
	public ResponseEntity<Object> join(@RequestBody @Valid RegisterRequest registerRequest,HttpServletResponse response) throws IOException {
		try {
			long memberNumber = memberRegisterService.regist(registerRequest);	
			
			response.sendRedirect("http://localhost/2022-07-06/member/detail/"+memberNumber);
			
			return ResponseEntity
					.status(HttpServletResponse.SC_OK)
					.contentType(MediaType.TEXT_PLAIN)
					.build();

			
		}catch(DuplicateMemberException e) {
			ErrorResponse message = new ErrorResponse("email is used");
			
			return ResponseEntity
					.status(HttpServletResponse.SC_CONFLICT)
					.contentType(MediaType.APPLICATION_JSON)
					.body(message);
		}	
	}
	
	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(){
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.contentType(MediaType.TEXT_PLAIN)
				.body(new ErrorResponse("not found"));
	}
}
