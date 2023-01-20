package ju.study.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ju.study.project.member.service.MemberService;
import ju.study.project.member.vo.MemberVO;


@Controller
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;


	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

//	@Resource(name="memberService")
//	private MemberService memberService;

	@Autowired
	private PasswordEncoder encoder;


	//회원가입
	@PostMapping("/join")
	public String Join(MemberVO memberVO) {


		String pw = encoder.encode(memberVO.getMemPw());
		memberVO.setMemPw(pw);

		System.out.println(memberVO);
		memberService.join(memberVO);


		return "redirect:/board/boardList";
	}

	//로그인
//	@PostMapping("/login")
//	public String login(MemberVO memberVO, HttpSession session) {
//
//
//
//		return "redirect:/board/boardList";
//	}
}
