package ju.study.project.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class boardServiceImpl implements boardService{

	@Autowired
	SqlSessionTemplate sqlSession;
}