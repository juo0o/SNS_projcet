package ju.study.project.member.service;

import ju.study.project.member.vo.MemberVO;

public interface MemberService {
	//회원가입
	void join(MemberVO memberVO);

	//로그인
	MemberVO login(MemberVO memberVO);

}
