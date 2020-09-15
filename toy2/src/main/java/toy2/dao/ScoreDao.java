package toy2.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import toy2.dao.sql.QuizSqls;
import toy2.dto.QuizDto;
import toy2.dto.ScoreDto;



@Repository
public class ScoreDao {
	private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<ScoreDto> rowMapper = BeanPropertyRowMapper.newInstance(ScoreDto.class);

    public ScoreDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
        		.withTableName("Score");
    }
    
//    public List<QuizDto> getScore(String nickname) {
//    	try {
//    		Map<String, String> params = new HashMap<>();
//    		
//    		params.put("nickname", nickname);
//    		
//			
//			return jdbc.query(QuizSqls.SELECT_USER_QUIZZES, params, rowMapper);
//			
//		}catch(EmptyResultDataAccessException e) {//해당 조건이 없을경우
//			return null;
//		}
//    }
	
	
	
	
}
