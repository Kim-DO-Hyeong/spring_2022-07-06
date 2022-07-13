package chapter07;

import java.util.Scanner;

import exception.DuplicateMemberException;
import exception.MemberNotFoundException;
import exception.WrongIdPasswordException;

public class Ex01 {
	private static Assembler assemlber;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanf = new Scanner(System.in);
		
		while(true) {
			System.out.println("명령어를 입력하세요");
			
			String command = scanf.nextLine();
			if(command.equals("exit")) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			
			if(command.startsWith("new")) {
				// 회원가입
				processNewCommand(command.split(" "));
			}else if(command.startsWith("change")) {
				// 정보 변경
				processChanageCommand(command.split(" "));
			}else {
				// 프로그램 사용 방법 출력 
				printHelp();
			} // end if
			
			
		} // end while
	
	} // end main
	
	public static void printHelp() {
		System.out.println("");
		
		System.out.println("<< 프로그램 사용법 >>");
		System.out.println("new 이메일 이름 비밀번호 비밀번호 확인 ");
		System.out.println("change 이메일 현재 비번 새로운 비번 ");
		
		System.out.println();
	}
	
	public static void processChanageCommand(String[] args) {
		if(args.length != 4) {
			printHelp();
			return ;
		}
		
		ChangePasswordService chpSvc  = assemlber.getChpSvc();
		
		try {
			chpSvc.changePassword(args[1], args[2], args[3]);
			System.out.println("비밀번호를 변경하였습니다");
		}catch(MemberNotFoundException e) {
			System.out.println("잘못된 이메일입니다");
		}catch(WrongIdPasswordException e) {
			System.out.println("이메일 또는 현재 비밀번호가 올바르지 않습니다");
		}
		System.out.println();
	}
	
	
	public static void processNewCommand(String[] args) {
		if(args.length != 5) {
			printHelp();
			return ;
		}
		
		MemberRegisterService memRegSvc = assemlber.getMemRegSvc();
		
		RegisterRequest regReq =  new RegisterRequest();
		regReq.setEmail(args[1]);
		regReq.setName(args[2]);
		regReq.setPassword(args[3]);
		regReq.setConfirmPassword(args[4]);
		
		if(!regReq.isPasswordEqualToConfirmPassword()) {
			System.out.println("비밀번호와 비밀번호 확인이 일치하지 않습니다");
			return ;
		}
		
		try {
			memRegSvc.regist(regReq);
			System.out.println("회원 가입이 완료되었습니다");
		}catch(DuplicateMemberException e) {
			System.out.println("이미 사용중인 이메일입니다");
		}
		
		System.out.println();
		
	}
	
}
