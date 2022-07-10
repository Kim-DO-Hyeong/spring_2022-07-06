package study;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component("study")
public class StudyDao {
	
	private Map<String,Member> memberData = new HashMap<>(); 	
	

	public Member selectByName(String name) {
		return memberData.get(name);
	}
	
	public void insert(Member member) {
		memberData.put(member.getName(), member);
	}

	public Map<String, Member> getMemberData() {
		return memberData;
	}

	public void setMemberData(Map<String, Member> memberData) {
		this.memberData = memberData;
	}
	
	
}
