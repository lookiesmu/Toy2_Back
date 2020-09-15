package toy2.dto;

public class QuizDto {
	private int id;
	private String content;
	private int answer;
		
	
	
	@Override
	public String toString() {
		return "QuizDto [id=" + id + ", content=" + content + ", answer=" + answer + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setQuizId(int id) { //sql문 응답을 받아 dao에서 jdbc 의 rowMapper가 처리할때 set+"" 부분의 이름을 DB와 비교하고 매칭함.
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	

}
