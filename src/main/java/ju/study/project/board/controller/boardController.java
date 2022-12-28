package ju.study.project.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/boardList")
	public String boardList(boolean isLoginFail, Model model) {
		model.addAttribute("isLoginFail", isLoginFail);
		
		
		return "content/board/board_list";
	}
}
