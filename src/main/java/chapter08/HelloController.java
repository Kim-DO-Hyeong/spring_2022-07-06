package chapter08;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(Model model, @RequestParam(value = "name") String name) {
		System.out.println("HelloController 에 hello 가 동작");
		
		model.addAttribute("name",name);
		// request.setAttribute("name",name); 같은 동작 
		
		return "hello";
	}
}
