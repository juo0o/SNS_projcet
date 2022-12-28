package ju.study.project.member.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class memberVO {
	private String memId;
	private String memPw;
	private String memName;
	private String memTell;
	private String memAddr;
	private String memEmail;
	private String joinDate;
	private String isAdmin;
}
