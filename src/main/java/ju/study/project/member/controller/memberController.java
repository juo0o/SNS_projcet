package ju.study.project.member.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ju.study.project.member.service.MemberService;
import ju.study.project.member.vo.MemberVO;


@Controller
@RequestMapping("/member")
public class MemberController {

	@Resource(name="memberService")
	private MemberService memberService;
	
	@PostMapping("/join")
	public String Join(MemberVO memberVO) {
		memberService.join(memberVO);
		
		return "redirect:/board/boardList";
	}
}
