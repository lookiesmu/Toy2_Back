package toy2.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import toy2.service.security.CustomUserDetails;
import toy2.dao.sql.*;

@Repository
public class UserDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<CustomUserDetails> rowMapper= BeanPropertyRowMapper.newInstance(CustomUserDetails.class);
	
	public UserDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
        		.withTableName("User")
                .usingGeneratedKeyColumns("user_id");
	}
	
	public CustomUserDetails findByNickName(String nickname) {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("nickname", nickname);
			return jdbc.queryForObject(UserDaoSqls.findByNickname, params, rowMapper);
		}catch(EmptyResultDataAccessException e) {//해당 조건이 없을경우
			return null;
		}
	}
	
	public int insertUser(CustomUserDetails newUser) {
   
    	
    	SqlParameterSource params = new BeanPropertySqlParameterSource(newUser);
		return insertAction.executeAndReturnKey(params).intValue();
    }
	
	
	
	
	
}
