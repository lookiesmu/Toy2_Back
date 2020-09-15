package toy2.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import toy2.dto.UserQuizDto;

@Repository
public class UserQuizDao {
	private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<UserQuizDto> rowMapper = BeanPropertyRowMapper.newInstance(UserQuizDto.class);

    public UserQuizDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
        		.withTableName("User_Quiz");
    }
    
    public int insertUserQuiz(UserQuizDto userQuiz) {   
    	
    	SqlParameterSource params = new BeanPropertySqlParameterSource(userQuiz);
    	
		return insertAction.execute(params);
    }
}
