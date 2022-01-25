package cu.cujae.pweb.jsf2SpringBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Role;
import cu.cujae.pweb.jsf2SpringBoot.domain.User;

@Repository
public class JdbcUserRepository implements IUserRepository {

   @Autowired
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

   @Autowired
   private JdbcTemplate jdbcTemplate;

   @Override
   public int count() {
      return jdbcTemplate
              .queryForObject("SELECT count(*) FROM \"user\"", Integer.class);
   }

   @Override
   public Optional<User> findById(Long id) {
      return namedParameterJdbcTemplate.queryForObject(
              "SELECT * FROM \"user\" where id = :id",
              new MapSqlParameterSource("id", id),
              (rs, rowNum) ->
                      Optional.of(new User(
                              rs.getLong("id"),
                              rs.getString("username"),
                              rs.getString("fullname"),
                              rs.getString("email"),
                              findRolesByUserId(id),
                              rs.getString("password")
                      ))
      );
   }

   @Override
   public List<Role> findRolesByUserId(Long id) {
      return namedParameterJdbcTemplate.query(
              "SELECT r.id, r.role_name FROM role r inner join user_role ur on r.id = ur.role_id where ur.user_id = :id",
              new MapSqlParameterSource("id", id),
              (rs, rowNum) ->
                      new Role(
                              rs.getLong("id"),
                              rs.getString("role_name")
                      )
      );
   }

   @Override
   public int save(User user) {
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      mapSqlParameterSource.addValue("username", user.getUsername());
      mapSqlParameterSource.addValue("fullname", user.getFullname());
      mapSqlParameterSource.addValue("email", user.getEmail());
      mapSqlParameterSource.addValue("password", user.getPassword());

      return namedParameterJdbcTemplate.update(
              "INSERT INTO \"user\" (username, fullname, email, password) "
                      + "VALUES (:username, :fullname, :email, :password)",
              mapSqlParameterSource);
   }

   @Override
   public int update(User user) {

      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      mapSqlParameterSource.addValue("id", user.getId());
      mapSqlParameterSource.addValue("username", user.getUsername());
      mapSqlParameterSource.addValue("fullname", user.getFullname());
      mapSqlParameterSource.addValue("email", user.getEmail());
      mapSqlParameterSource.addValue("password", user.getPassword());

      return namedParameterJdbcTemplate.update(
              "UPDATE \"user\" SET username = :username, fullname = :fullname, email = :email, password = :password WHERE id = :id",
              mapSqlParameterSource);
   }

   @Override
   public int deleteById(Long id) {
      return jdbcTemplate.update(
              "DELETE FROM \"user\" WHERE id = ?",
              id);
   }

   @Override
   public List<User> findAll() {
      return namedParameterJdbcTemplate.query(
              "SELECT * FROM \"user\"",
              (rs, rowNum) ->
                      new User(
                              rs.getLong("id"),
                              rs.getString("username"),
                              rs.getString("fullname"),
                              rs.getString("email"),
                              findRolesByUserId(rs.getLong("id")),
                              rs.getString("password")
                      )
      );
   }

   @Override
   public List<User> findByAttribute(String username, String full_name, String email) {
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      mapSqlParameterSource.addValue("username", "%" + username + "%");
      mapSqlParameterSource.addValue("fullname", "%" + full_name + "%");
      mapSqlParameterSource.addValue("email", "%" + email + "%");

      return namedParameterJdbcTemplate.query(
              "SELECT * FROM \"user\" WHERE username like :username AND fullname like :fullname AND email like :email",
              mapSqlParameterSource,
              (rs, rowNum) ->
                      new User(
                              rs.getLong("id"),
                              rs.getString("username"),
                              rs.getString("fullname"),
                              rs.getString("email"),
                              findRolesByUserId(rs.getLong("id")),
                              rs.getString("password")
                      )
      );
   }

   @Override
   public User findByUserName(String username) {
      try {
         return namedParameterJdbcTemplate.queryForObject(
                 "SELECT * FROM \"user\" where username = :username",
                 new MapSqlParameterSource("username", username),
                 (rs, rowNum) ->
                         new User(
                                 rs.getLong("id"),
                                 rs.getString("username"),
                                 rs.getString("fullname"),
                                 rs.getString("email"),
                                 findRolesByUserId(rs.getLong("id")),
                                 rs.getString("password")
                         )
         );
      } catch (EmptyResultDataAccessException e) {
         return null;
      }
   }
}
