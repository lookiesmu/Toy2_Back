package toy2.dao.sql;

public class UserDaoSqls {
	public static final String findByNickname ="select * from User where nickname = :nickname";
	//public static final String FIND_ID_BY_NICKNAME="select user_id from User where nickname= :nickname";
	public static final String searchByUserId= "select user_id as userId, nickname, score from User, Score where answerer = user_id and examiner = :userId order by score desc";
}
