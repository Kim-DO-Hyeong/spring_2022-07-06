package chapter04;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"chapter04"}, excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes= {MemberDao.class}))
//@ComponentScan(basePackages = {"chapter04"}, excludeFilters = @Filter(type = FilterType.REGEX, pattern="chapter04\\..*Dao"))
// chatpter04 에 있지만 제외시키는 excludeFilters 속성 ( 정규식 표현 ) ex ) chapter04. 으로 시작하고 Dao 로 끝나는 패턴들을 제외할 대상으로 지정  
// 꼭 정규식 말고 지정할 타입을 ASSIGNABLE_TYPE 로 하면 제외할 대상을 지정 가능 
public class AppCtx {

	
	@Bean
	@Qualifier("printer2")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	

	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter vp = new VersionPrinter();

		vp.setMajor(1);
		vp.setMinor(4);

		return vp;
	}
	
//	@Bean
//	public DateTimeFormatter dateTimeFormatter() {
//		return DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분 ss초");
//	}

}
