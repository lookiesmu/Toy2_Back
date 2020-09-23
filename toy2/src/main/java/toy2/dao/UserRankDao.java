package toy2.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import toy2.dto.*;
import toy2.dao.sql.UserDaoSqls;

@Repository
public class UserRankDao {
   private NamedParameterJdbcTemplate jdbc;
   private RowMapper<UserRankDto> rowMapper= BeanPropertyRowMapper.newInstance(UserRankDto.class);

   public UserRankDao(DataSource dataSource) {
      this.jdbc=new NamedParameterJdbcTemplate(dataSource);
   }
   public List<UserRankDto> searchRank(Long userId) {
      Map<String, Long> params = new HashMap<String, Long>();
      params.put("userId", userId);
      return jdbc.query(UserDaoSqls.searchByUserId, params, rowMapper);
   }
}