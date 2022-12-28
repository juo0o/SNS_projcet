package ju.study.project.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ju.study.project.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public void join(MemberVO memberVO) {
		sqlSession.insert("memberMapper.join",memberVO);
	}
	
	
	
}
