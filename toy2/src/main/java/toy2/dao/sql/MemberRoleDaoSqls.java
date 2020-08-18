package toy2.dao.sql;

public class MemberRoleDaoSqls {
	public static final String SELECT_ALL_BY_EMAIL = "SELECT ur.id, ur.user_id, ur.role_name FROM user_role ur JOIN user u ON ur.user_id = u.id WHERE u.email = :email";
}
