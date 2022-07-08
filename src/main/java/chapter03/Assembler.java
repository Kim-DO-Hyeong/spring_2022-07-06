package chapter03;

// 의존 주입을 하기 위한 클래스 

public class Assembler {
	
	private MemberRegisterService memRegSvc;
	private ChangePasswordService chpSvc;

	private MemberDao memberDao;
	
	public Assembler(){
		memberDao = new MemberDao();
		
		memRegSvc = new MemberRegisterService(memberDao);
		
		chpSvc = new ChangePasswordService();
		chpSvc.setMemberDao(memberDao);
	}

	public MemberRegisterService getMemRegSvc() {
		return memRegSvc;
	}

	public ChangePasswordService getChpSvc() {
		return chpSvc;
	}

}
