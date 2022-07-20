package chapter11;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	@GetMapping
	public ModelAndView form() {
		List<String> job = new ArrayList<>();
		
		job.add("서버 개발자"); job.add("프론트 개발자"); job.add("풀스택 개발자");
		
		List<String> tool = new ArrayList<>();
		
		tool.add("Eclipse"); tool.add("Intelij"); tool.add("VS Code");
		
		Question q1 = new Question("당신의 역할은?",job);
		Question q2 = new Question("많이 사용하는 개발도구는?",tool);
		Question q3 = new Question("하고 싶은 말은?",null);
		
		List<Question> questions = new ArrayList<>();
		
		questions.add(q1); questions.add(q2); questions.add(q3);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("survey/form");
		mav.addObject("questions",questions);
		
		
		return mav;
	}
	
//	@GetMapping
//	public String form(Model model) {
//		List<String> job = new ArrayList<>();
//		
//		job.add("서버 개발자"); job.add("프론트 개발자"); job.add("풀스택 개발자");
//		
//		List<String> tool = new ArrayList<>();
//		
//		tool.add("Eclipse"); tool.add("Intelij"); tool.add("VS Code");
//		
//		Question q1 = new Question("당신의 역할은 무엇입니까?",job);
//		Question q2 = new Question("많이 사용하는 개발도구는 무엇입니까?",tool);
//		Question q3 = new Question("하고 싶은 말이 있나요?",null);
//		
//		List<Question> questions = new ArrayList<>();
//		
//		questions.add(q1); questions.add(q2); questions.add(q3);
//		
//		model.addAttribute("question",questions);
//		
//		return "survey/form";
//	}
	
	
	@PostMapping
	public String submit(@ModelAttribute("ansData") AnsweredData data) {
		return "survey/submitted";
	}
}
