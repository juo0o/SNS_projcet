package ju.study.project.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ju.study.project.member.vo.MemberVO;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO loginInfo = sqlSession.selectOne("memberMapper.login", username);

		//로그인 시 아이디를 잘못 입력한 경우
		if(loginInfo == null) {
			throw new UsernameNotFoundException("아이디를 찾을 수 없습니다.");
		}

		UserDetails userDetail = User.withUsername(loginInfo.getMemId())
									.password(loginInfo.getMemPw())
									.roles(loginInfo.getMemRole())
									.build();

		return userDetail;
	}

}






