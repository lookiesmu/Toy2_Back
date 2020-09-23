package toy2.dto;

public class UserRankDto {
	   private Long userId;
	   private String nickname;
	   private int score;
	   
	   public Long getUserId() {
	      return userId;
	   }
	   @Override
	   public String toString() {
	      return "UserRankDto [userId=" + userId + ", nickname=" + nickname + ", score=" + score + "]";
	   }
	   public String getNickname() {
	      return nickname;
	   }
	   public int getScore() {
	      return score;
	   }
	   public void setUserId(Long userId) {
	      this.userId = userId;
	   }
	   public void setNickname(String nickname) {
	      this.nickname = nickname;
	   }
	   public void setScore(int score) {
	      this.score = score;
	   }

}
