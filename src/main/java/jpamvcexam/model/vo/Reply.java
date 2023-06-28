package jpamvcexam.model.vo;

import javax.persistence.*;

@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String content;
	@ManyToOne( optional = false ) //관계설정*****메인 글 정보 없이 댓글 달 수 없기 때문에 optional = false
	@JoinColumn(name="refid")
	private Meeting refid;//타입 변수 선언(미팅 entity객체의 참조값..?)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}	
	public Meeting getRefid() {
		return refid;
	}
	public void setRefid(Meeting refid) {
		this.refid = refid;
	}
	@Override
	public String toString() {
		return "MeetingReplyVO [id=" + id + ", name=" + name + ", content=" +content + ", refid=" + refid + "]";
	}
	
}