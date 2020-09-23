package toy2.dto;

public class ScoreDto {
	private Long examiner;
	private Long answerer;
	private int score;
	
	
	
	@Override
	public String toString() {
		return "ScoreDto [examiner=" + examiner + ", answerer=" + answerer + ", score=" + score + "]";
	}
	public Long getExaminer() {
		return examiner;
	}
	public void setExaminer(Long examiner) {
		this.examiner = examiner;
	}
	public Long getAnswerer() {
		return answerer;
	}
	public void setAnswerer(Long answerer) {
		this.answerer = answerer;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	

}
