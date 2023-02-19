package ju.study.project.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ju.study.project.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public BoardVO selectWD() {
		return sqlSession.selectOne("boardMapper.selectWD");
	}
}
