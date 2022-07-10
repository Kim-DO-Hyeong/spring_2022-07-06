package study;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
	
	@Bean
	@Qualifier("study")
	public StudyDao studyDao1() {
		return new StudyDao();
	}
	
	@Bean
	public StudyDao studyDao2() {
		return new StudyDao();
	}
	@Bean
	@Qualifier("p")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	@Bean
	public ExMemberPrinter memberPrinter2() {
		return new ExMemberPrinter();
	}
	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		return new MemberInfoPrinter();
	}
	
	@Bean
	public DateTimeFormatter dateTimeFormatter(MemberPrinter memberPrinter) {
		return DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분 ss초");
	}
}

