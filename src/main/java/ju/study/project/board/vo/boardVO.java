package ju.study.project.board.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class boardVO {
	private int boardNum;
	private String title;
	private String content;
	private String writer;
	private String createDate;
	private int readCnt;
	private String isPrivate;
	private String boardPw;
}
