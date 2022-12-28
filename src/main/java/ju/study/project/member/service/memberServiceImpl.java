package ju.study.project.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class memberServiceImpl implements memberService{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	
	
}
