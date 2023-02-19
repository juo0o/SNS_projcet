package ju.study.project.board.controller;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ju.study.project.board.service.BoardService;
import ju.study.project.board.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	
	@Resource(name = "boardService")
	private BoardService boardService;
	
	
		
	@GetMapping("/boardList")
	public String boardList(boolean isLoginFail, Model model) {

		System.out.println("Ddfdsfsd");
		System.out.println("Ddfdsfsd");
		System.out.println("Ddfdsfsd");
		System.out.println("Ddfdsfsd");

//		model.addAttribute("isLoginFail", isLoginFail);


		return "content/board/board_list";
	}
	
	
	//게시글 작성 페이지
	@GetMapping("/regFeed")
	public String regFeed(Model model,Authentication authentication,BoardVO boardVO) {
		
		User user =(User)authentication.getPrincipal();
		boardVO.setWriter(user.getUsername());
		
		model.addAttribute("WD", boardService.selectWD());
		
		return "content/board/reg_feed";
	}
}
