package cu.cujae.pweb.jsf2SpringBoot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRoleRepository implements RoleRepository {

   @Autowired
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

   @Autowired
   private JdbcTemplate jdbcTemplate;

   @Override
   public int insertRol(long userId, long roleId) {

      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      mapSqlParameterSource.addValue("user_id", userId);
      mapSqlParameterSource.addValue("role_id", roleId);

      return namedParameterJdbcTemplate.update(
              "INSERT INTO user_role (user_id, role_id) "
                      + "VALUES (:user_id, :role_id)",
              mapSqlParameterSource);
   }
}
